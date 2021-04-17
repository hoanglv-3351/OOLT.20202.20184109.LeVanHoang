import pygame
from pygame.locals import *
from pygame import mixer
import pickle
from os import path

pygame.mixer.pre_init(44100, -16, 2, 512)
mixer.init()
pygame.init()

# clock = pygame.time.Clock()
# fps = 60

screen_width = 800
screen_height = 800

screen = pygame.display.set_mode((screen_width, screen_height))
pygame.display.set_caption('Platformer')

# define font
font = pygame.font.SysFont('Bauhaus 93', 70)
font_score = pygame.font.SysFont('Bauhaus 93', 30)
font_back = pygame.font.SysFont('Bauhaus 93', 15)

# define game variables
max_levels = 7
level = 1
tile_size = 40
game_over = 2
score = 0
menu = True

# define colors
WHITE = (255,255,255)
BLUE = (0, 0, 255)

# load images
sun_img = pygame.image.load('img/sun.png')
bg_img = pygame.image.load('img/sky.png')
restart_img = pygame.image.load('img/restart_btn.png')
start_img = pygame.image.load('img/start_btn.png')
start_img = pygame.transform.scale(start_img, (200, 120))
exit_img = pygame.image.load('img/exit_btn.png')
exit_img = pygame.transform.scale(exit_img, (200, 120))

# load sounds
# pygame.mixer.music.load('img/music.wav')
# pygame.mixer.music.play(-1, 0.0, 1000)
coin_fx = pygame.mixer.Sound('img/coin.wav')
coin_fx.set_volume(0.5)
jump_fx = pygame.mixer.Sound('img/jump.wav')
jump_fx.set_volume(0.5)
game_over_fx = pygame.mixer.Sound('img/game_over.wav')
game_over_fx.set_volume(0.5)

def draw_grid():
	for line in range(0, 20):
		pygame.draw.line(screen, (255, 255, 255), (0, line * tile_size), (screen_width, line * tile_size))
		pygame.draw.line(screen, (255, 255, 255), (line * tile_size, 0), (line * tile_size, screen_height))

def draw_text(text, font, text_col, x, y):
	img = font.render(text, True, text_col)
	screen.blit(img, (x, y))

def reset_level(level):
	player.reset(80, screen_height - 100)
	blob_group.empty()
	platform_group.empty()
	lava_group.empty()
	coin_group.empty()
	exit_group.empty()
	# load data
	if path.exists(f'level{level}_data'):
		pickle_in = open(f'level{level}_data', 'rb')
		world_data = pickle.load(pickle_in)
	world = World(world_data)
	return world

class Button():
	def __init__(self, x, y, image):
		self.image = image
		self.rect = self.image.get_rect()
		self.rect.x = x
		self.rect.y = y
		self.clicked = False

	def draw(self):
		action = False
		# get mouse position
		pos = pygame.mouse.get_pos()
		# check mouseover and clicked condition
		if self.rect.collidepoint(pos):
			if pygame.mouse.get_pressed()[0] == 1 and self.clicked == False:
				action = True
				self.clicked = True

		if pygame.mouse.get_pressed()[0] == 0:
			self.clicked = False
		# draw button
		screen.blit(self.image, self.rect)
		return action

class Player():
	def __init__(self, x, y):
		self.reset(x,y)

	def update(self, game_over):
		dx = 0
		dy = 0
		walk_cooldown = 5
		col_thresh = 20
		if game_over >= 0:
			# get keypresses
			key = pygame.key.get_pressed()
			if key[pygame.K_LEFT]:
				dx -= 4
				self.counter += 1
				self.direction = -1
			if key[pygame.K_RIGHT]:
				dx += 4
				self.counter += 1
				self.direction = 1
			if key[pygame.K_UP]  and self.in_air == False: # condition self.jumped == False: cannot hold
				jump_fx.play()
				self.vel_y -= 15
				self.jumped = True
			if key[pygame.K_UP] == False:
				self.jumped = False
			if key[pygame.K_LEFT] == False and key[pygame.K_RIGHT] == False:
				self.counter = 0
				self.index = 0
				if self.direction == 1:
					self.image = self.images_right[self.index]
				if self.direction == -1:
					self.image = self.images_left[self.index]
			# handle animation
			if self.counter > walk_cooldown:
				self.counter = 0
				self.index += 1
				if self.index >= len(self.images_right):
					self.index = 0
				if self.direction == 1:
					self.image = self.images_right[self.index]
				if self.direction == -1:
					self.image = self.images_left[self.index]
			# add gravity
			self.vel_y += 1
			if self.vel_y > 10:
				self.vel_y = 10
			dy += self.vel_y
			
			#check for collision
			self.in_air = True
			for tile in world.tile_list:
				# check for collision in x direction
				if tile[1].colliderect(self.rect.x + dx, self.rect.y, self.width, self.height):
					dx = 0
				# check for collision in y direction
				if tile[1].colliderect(self.rect.x, self.rect.y + dy, self.width, self.height):
			 		# check if below the ground i.e. jumping
					if self.vel_y < 0:
						dy = tile[1].bottom - self.rect.top
						self.vel_y = 0
			 		# check if below the ground i.e. falling
					elif self.vel_y >= 0:
						dy = tile[1].top - self.rect.bottom
						self.vel_y = 0
						self.in_air = False


			# check for collision with enemies
			if pygame.sprite.spritecollide(self, blob_group, False):
				game_over -= 1
				game_over_fx.play()
				if game_over >= 0:
					self.rect.x = 80
					self.rect.y = screen_height - 100
			# check for collision with lava
			if pygame.sprite.spritecollide(self, lava_group, False):
				game_over -= 1
				game_over_fx.play()
				if game_over >= 0:
					self.rect.x = 80
					self.rect.y = screen_height - 100
			# check for collision with exit
			if pygame.sprite.spritecollide(self, exit_group, False):
				game_over = 10

			# check for collision with platforms
			for platform in platform_group:
				# collision in x direction
				if platform.rect.colliderect(self.rect.x + dx, self.rect.y, self.width, self.height):
					dx = 0
				# collision in y direction
				if platform.rect.colliderect(self.rect.x, self.rect.y + dy, self.width, self.height):
					# check if below platforms
					if abs((self.rect.top + dy) - platform.rect.bottom) < col_thresh:
						self.vel_y = 0
						dy = platform.rect.bottom - self.rect.top
					# check if above platforms
					elif abs((self.rect.bottom - dy) - platform.rect.top) < col_thresh:
						self.rect.bottom = platform.rect.top -1
						self.in_air = False
						self.vel_y = 0
						dy = 0
					# move side way with platforms
					if platform.move_x != 0:
						self.rect.x += 2 * platform.move_direction * platform.move_x

			# update player coordinates
			self.rect.x += dx
			self.rect.y += dy

			# if self.rect.bottom > screen_height - 40:
			# 	self.rect.bottom = screen_height - 40
			# 	dy = 0
		
		elif game_over == -1:
			self.image = self.dead_image
			self.rect.y -= 10
		# draw player onto screen
		screen.blit(self.image, self.rect)
		# pygame.draw.rect(screen, (255, 255, 255), self.rect, 2)
		return game_over

	def reset(self, x, y):
		self.images_right = []
		self.images_left = []

		self.index = 0
		self.counter = 0

		for num in range(1, 5):
			img_right = pygame.image.load(f'img/guy{num}.png')
			img_right = pygame.transform.scale(img_right, (30, 60))
			img_left = pygame.transform.flip(img_right, True, False)
			self.images_right.append(img_right)
			self.images_left.append(img_left)

		self.image = self.images_right[self.index]
		self.dead_image = pygame.image.load('img/ghost.png')
		self.rect = self.image.get_rect()
		self.rect.x = x
		self.rect.y = y
		self.width = self.image.get_width()
		self.height = self.image.get_height()
		self.vel_y = 0
		self.jumped = False
		self.direction = 0
		self.in_air = True

class World():
	def __init__(self, data):
		self.tile_list = []
		#load images
		dirt_img = pygame.image.load('img/dirt.png')
		grass_img = pygame.image.load('img/grass.png')
		row_count = 0
		for row in data:
			col_count = 0
			for tile in row:
				if tile == 1:
					img = pygame.transform.scale(dirt_img, (tile_size, tile_size))
					img_rect = img.get_rect()
					img_rect.x = col_count * tile_size
					img_rect.y = row_count * tile_size
					tile = (img, img_rect)
					self.tile_list.append(tile)
				if tile == 2:
					img = pygame.transform.scale(grass_img, (tile_size, tile_size))
					img_rect = img.get_rect()
					img_rect.x = col_count * tile_size
					img_rect.y = row_count * tile_size
					tile = (img, img_rect)
					self.tile_list.append(tile)
				if tile == 3:
					blob = Enemy(col_count*tile_size, row_count*tile_size + 10)
					blob_group.add(blob)
				if tile == 4:
					platform = Platform(col_count*tile_size, row_count*tile_size, 1, 0)
					platform_group.add(platform)
				if tile == 5:
					platform = Platform(col_count*tile_size, row_count*tile_size, 0, 1)
					platform_group.add(platform)					
				if tile == 6:
					lava = Lava(col_count*tile_size, row_count*tile_size+20)
					lava_group.add(lava)
				if tile == 7:
					coin = Coin(col_count*tile_size + tile_size//2, row_count*tile_size+20)
					coin_group.add(coin)
				if tile == 8:
					exit = Exit(col_count*tile_size, row_count*tile_size - tile_size)
					exit_group.add(exit)
				col_count += 1
			row_count += 1

	def draw(self):
		for tile in self.tile_list:
			screen.blit(tile[0], tile[1])

class Enemy(pygame.sprite.Sprite):
	def __init__(self, x, y):
		pygame.sprite.Sprite.__init__(self)
		img = pygame.image.load('img/blob.png')
		self.image = pygame.transform.scale(img, (40, 30))
		self.rect = self.image.get_rect()
		self.rect.x = x
		self.rect.y = y
		self.move_direction = 1
		self.move_counter = 0

	def update(self):
		self.rect.x += self.move_direction
		self.move_counter += 1
		if self.move_counter > 40:
			self.move_direction *= -1
			self.move_counter *= -1
		# pygame.draw.rect(screen, (255,255,255), self.rect, 2)

class Platform(pygame.sprite.Sprite):
	def __init__(self, x, y, move_x, move_y):
		pygame.sprite.Sprite.__init__(self)
		img = pygame.image.load('img/platform.png')
		self.image = pygame.transform.scale(img, (tile_size, tile_size // 2))
		self.rect = self.image.get_rect()
		self.rect.x = x
		self.rect.y = y
		self.move_counter = 0
		self.move_direction = 1
		self.move_x = move_x
		self.move_y = move_y
	def update(self):
		self.rect.x += self.move_direction * self.move_x
		self.rect.y += self.move_direction * self.move_y
		self.move_counter += 1
		if self.move_counter > 40:
			self.move_direction *= -1
			self.move_counter *= -1
		
class Lava(pygame.sprite.Sprite):
	def __init__(self, x, y):
		pygame.sprite.Sprite.__init__(self)
		img = pygame.image.load('img/lava.png')
		self.image = pygame.transform.scale(img, (tile_size, tile_size // 2))
		self.rect = self.image.get_rect()
		self.rect.x = x
		self.rect.y = y

class Coin(pygame.sprite.Sprite):
	def __init__(self, x, y):
		pygame.sprite.Sprite.__init__(self)
		img = pygame.image.load('img/coin.png')
		self.image = pygame.transform.scale(img, (tile_size // 2, tile_size // 2))
		self.rect = self.image.get_rect()
		self.rect.center = (x, y)

class Exit(pygame.sprite.Sprite):
	def __init__(self, x, y):
		pygame.sprite.Sprite.__init__(self)
		img = pygame.image.load('img/exit.png')
		self.image = pygame.transform.scale(img, (tile_size, tile_size * 2))
		self.rect = self.image.get_rect()
		self.rect.x = x
		self.rect.y = y

world_data =[]
# [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
# [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
# [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
# [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
# [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
# [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
# [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
# [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
# [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
# [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
# [1, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1],
# [1, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1],
# [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 1],
# [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
# [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 1],
# [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1],
# [1, 0, 0, 0, 0, 0, 2, 0, 2, 0, 2, 0, 0, 1, 1, 1, 1, 1, 1, 1],
# [1, 0, 0, 0, 0, 2, 1, 6, 1, 6, 1, 6, 6, 1, 1, 1, 1, 1, 1, 1],
# [1, 0, 0, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
# [1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
# ]

player = Player(80, screen_height - 100)

blob_group = pygame.sprite.Group()

platform_group = pygame.sprite.Group()

lava_group = pygame.sprite.Group()

coin_group = pygame.sprite.Group()

exit_group = pygame.sprite.Group()

# create dummy coin for showing the score
score_coin = Coin(tile_size//2, tile_size//2)
coin_group.add(score_coin)

# load in level data and create world
if path.exists(f'level{level}_data'):
	pickle_in = open(f'level{level}_data', 'rb')
	world_data = pickle.load(pickle_in)
world = World(world_data)

# create button
restart_button = Button(screen_width // 2 - 50, screen_height // 2 + 100, restart_img)
start_button = Button(screen_width // 2 - 250, screen_height // 2, start_img)
exit_button = Button(screen_width // 2 + 50, screen_height // 2, exit_img)

run = True
while run:
	# clock.tick(fps)
	screen.blit(bg_img, (0, 0))
	screen.blit(sun_img, (80, 80))

	if menu:
		if start_button.draw():
			menu = False
		if exit_button.draw():
			run = False
		
	else:
		world.draw()

		if game_over >= 0 and game_over != 10:
			blob_group.update()
			platform_group.update()
			# check if coin has been collected
			if pygame.sprite.spritecollide(player, coin_group, True):
				coin_fx.play()
				score += 1
				
			# update score
			draw_text('x '+ str(score), font_score, WHITE, tile_size , 2)
			draw_text(' Level ' + str(level), font_score, WHITE, screen_width//2 - 50, 10)

		blob_group.draw(screen)
		platform_group.draw(screen)
		lava_group.draw(screen)
		coin_group.draw(screen)
		exit_group.draw(screen)

		game_over = player.update(game_over)

			# if player has died
		if game_over == -1:
			draw_text('GAME OVER', font, BLUE, screen_width//2 - 180, screen_height//2)
			game_over_fx.play()
			if restart_button.draw():
				world_data = []
				world = reset_level(level)
				game_over = 2
				score_level = 0

		if game_over == 10:
			# print("finish")
			level += 1
			if level <= max_levels:
				# reset level
				world_data = []
				world = reset_level(level)
				game_over = 2

			else: 
				# restart game
				# game_over = -10
				draw_text('YOU WIN', font, BLUE, screen_width // 2 - 140, screen_height // 2)
				draw_text('Total score: ' + str(score), font_back, BLUE, screen_width // 2 - 50, screen_height//2 + 80)
				draw_text('Back to menu', font_back, BLUE, screen_width // 2 - 50, screen_height // 2 + 100)
				level = max_levels
				if player.in_air == False:
					player.rect.x = -99
					player.rect.y = -99
				if pygame.mouse.get_pressed()[0] == True:
					menu = True
					level = 1
					score = 0
					world_data = []
					world = reset_level(level)
					game_over = 2

		# draw_grid()

	for event in pygame.event.get():
		if event.type == pygame.QUIT:
			run = False

	pygame.display.update()
pygame.quit()