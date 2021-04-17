import pygame
import pickle
from os import path

pygame.init()

margin = 130
screen_width = 800
screen_height = 800 # + margin
tile_size = 40
screen = pygame.display.set_mode((screen_width + margin, screen_height))

# define color
WHITE = (255, 255, 255)
GREEN = (0, 255, 0)

font = pygame.font.SysFont('Bauhaus 93', 30)

# define game variables

level = 1

world = []
for row in range(20):
	r = [0] * 20
	world.append(r)
for tile in range(0, 20):
	world[19][tile] = 2
	world[tile][19] = 1
	world[0][tile] = 1
	world[tile][0] = 1

# load images
sun_img = pygame.image.load('img/sun.png')
sun_img = pygame.transform.scale(sun_img, (tile_size, tile_size))
bg_img = pygame.image.load('img/sky.png')
dirt_img = pygame.image.load('img/dirt.png')
grass_img = pygame.image.load('img/grass.png')
blob_img = pygame.image.load('img/blob.png')
platform_x_img = pygame.image.load('img/platform_x.png')
platform_y_img = pygame.image.load('img/platform_y.png')
lava_img = pygame.image.load('img/lava.png')
coin_img = pygame.image.load('img/coin.png')
exit_img = pygame.image.load('img/exit.png')
save_img = pygame.image.load('img/save_btn.png')
load_img = pygame.image.load('img/load_btn.png')

def draw_text(text, font, color, x, y):
	img = font.render(text, True, color)
	screen.blit(img, (x, y))


def draw_grid():
	for c in range(1, 21):
		pygame.draw.line(screen, WHITE, (tile_size*c, 0), (tile_size*c, screen_height )) # height - margin
		pygame.draw.line(screen, WHITE, (0, tile_size*c), (screen_width, tile_size*c)) # height - margin

def draw_world():
	for row in range(20):
		for col in range(20):
			if world[row][col] == 1:
				img = pygame.transform.scale(dirt_img, (tile_size, tile_size))
				screen.blit(img, (col * tile_size, row * tile_size))
			if world[row][col] == 2:
				img = pygame.transform.scale(grass_img, (tile_size, tile_size))
				screen.blit(img, (col * tile_size, row * tile_size))
			if world[row][col] == 3:
				img = pygame.transform.scale(blob_img, (tile_size, int(tile_size * 0.7)))
				screen.blit(img, (col * tile_size, row * tile_size + int(tile_size * 0.3)))
			if world[row][col] == 4:
				img = pygame.transform.scale(platform_x_img, (tile_size, tile_size//2))
				screen.blit(img, (col * tile_size, row * tile_size))
			if world[row][col] == 5:
				img = pygame.transform.scale(platform_y_img, (tile_size, tile_size//2))
				screen.blit(img, (col * tile_size, row * tile_size))
			if world[row][col] == 6:
				img = pygame.transform.scale(lava_img, (tile_size, tile_size // 2))
				screen.blit(img, (col * tile_size, row * tile_size + tile_size//2))
			if world[row][col] == 7:
				img = pygame.transform.scale(coin_img, (tile_size // 2, tile_size // 2))
				screen.blit(img, (col * tile_size + 10, row * tile_size + 10))
			if world[row][col] == 8:
				img = pygame.transform.scale(exit_img, (tile_size, tile_size * 2))
				screen.blit(img, (col * tile_size, row * tile_size - tile_size))
			
class Button():
	def __init__(self, x, y, image):
		self.image = image
		self.rect = self.image.get_rect()
		self.rect.x = x
		self.rect.y = y
		self.clicked = False
	def draw(self):
		action = False
		pos = pygame.mouse.get_pos()

		if self.rect.collidepoint(pos):
			if pygame.mouse.get_pressed()[0] == 1 and self.clicked == False:
				action = True
				self.clicked = True
		if pygame.mouse.get_pressed()[0] == False:
			self.clicked = False

		screen.blit(self.image, (self.rect.x, self.rect.y))
		return action

save_button = Button(screen_width+25, tile_size*3, save_img)
load_button = Button(screen_width+25, tile_size*5, load_img)

run = True
while run:
	screen.blit(bg_img, (0, 0))
	screen.blit(sun_img, (tile_size * 2, tile_size * 2))
	draw_grid()
	draw_world()
	draw_text(f'Level: {level}', font, WHITE, screen_width // 2 - 60, 10)

	if save_button.draw():
		with open(f'level{level}_data', 'wb') as pickle_out:
			pickle.dump(world, pickle_out)
	if load_button.draw():
		if path.exists(f'level{level}_data'):
			with open(f'level{level}_data', 'rb') as pickle_in:
				world = pickle.load(pickle_in)

	pos = pygame.mouse.get_pos()
	x = pos[0] // tile_size
	y = pos[1] // tile_size

	for event in pygame.event.get():
		if event.type == pygame.QUIT:
			run = False

		if event.type == pygame.MOUSEBUTTONDOWN:
			if x < 20 and y < 20:
				if pygame.mouse.get_pressed()[0] == 1:
					world[y][x] += 1
					if world[y][x] > 8:
						world[y][x] = 0
				if pygame.mouse.get_pressed()[2] == 1:
					world[y][x] -= 1
					if world[y][x] < 0:
						world[y][x] = 8
		if event.type == pygame.KEYDOWN:
			if event.key == pygame.K_UP:
				level += 1
			if event.key == pygame.K_DOWN and level > 1:
				level -= 1

	pygame.display.update()
pygame.quit()

















