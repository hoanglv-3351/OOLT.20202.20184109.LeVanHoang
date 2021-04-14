package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.order.*;

import java.util.Scanner;

public class Aims {
    static Scanner scanner = new Scanner(System.in);    

    public static void showMenu() {
        System.out.println("Order Management Application: ");
        System.out.println("--------------------------------");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void menuItems() {
        System.out.println("Chon media muon them: ");
        System.out.println("1. Book");
        System.out.println("2. CompactDisc");
        System.out.println("3. DigitalVideoDisc");
        System.out.println("0. back");
    }

    public static void menuBook() {
        System.out.println("Chon sach: ");
        System.out.println("1. Book 1");
        System.out.println("2. Book 2");
        System.out.println("0. Back");
    }

    public static void menuCD() {
        System.out.println("Chon CD: ");
        System.out.println("1. CD 1");
        System.out.println("2. CD 2");
        System.out.println("0. Back");
    }

    public static void menuTrack() {
        System.out.println("Chon bai hat: ");
        System.out.println("1. Track 1");
        System.out.println("2. Track 2");
        System.out.println("3. Track 3");
        System.out.println("0. Back");
    }

    public static void menuDVD() {
        System.out.println("Chon DVD: ");
        System.out.println("1. DVD 1");
        System.out.println("2. DVD 2");
        System.out.println("3. DVD 3");
        System.out.println("0. Back");
    }

    public static void askPlayDVD(DigitalVideoDisc dvd) {
        System.out.println("Do you want to play this dvd?\n1. Yes\n0. No");
        int rep = scanner.nextInt();
        if(rep == 1){
            dvd.play();
        }
    }

    public static void askPlayCD(CompactDisc cd) {
        System.out.println("Do you want to play this cd?\n1. Yes\n0. No");
        int rep = scanner.nextInt();
        if(rep == 1) {
            cd.play();
        }
    }

    public static Order unitTestAdd1(Order myOrder) {
        myOrder = new Order();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 1, 87, "Roger Allers");
        myOrder.addMedia(dvd1);
        System.out.println("Total cost is: " + myOrder.totalCost());
        System.out.println("---------------------------");
        return myOrder;
    }

    public static Order unitTestAdd2(Order myOrder) {
        myOrder = new Order();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 1, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 2, 124, "George Lucas");
        myOrder.addMedia(dvd1, dvd2);
        System.out.println("Total cost is: " + myOrder.totalCost());
        System.out.println("---------------------------");
        return myOrder;
    }

    public static Order unitTestAddArr(Order myOrder) {
        myOrder = new Order();
        DigitalVideoDisc [] dvdList = new DigitalVideoDisc[3];
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 1, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 2, 124, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Tom & Jerry", "Animation", 18.99f, 3, 90, "John Musker");
        dvdList[0] = dvd1;
        dvdList[1] = dvd2;
        dvdList[2] = dvd3;
        myOrder.addMedia(dvdList);
        System.out.println("Total cost is: " + myOrder.totalCost());
        System.out.println("---------------------------");
        return myOrder;
    }

    public static Order unitTestAddSome(Order myOrder) {
        myOrder = new Order();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 1, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 2, 124, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Tom & Jerry", "Animation", 18.99f, 3, 90, "John Musker");
        Book sach = new Book("sach", "tieuthuyet", 12.22f, 4);
        myOrder.addMedia(dvd1, dvd2, dvd3, dvd3, dvd2, dvd1, sach);
        System.out.println("Total cost is: " + myOrder.totalCost());
        System.out.println("---------------------------");
        return myOrder;
    }

    public static void main(String[] args){
        Order [] myOrder = new Order[Order.MAX_LIMITTED_ORDERS];
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 1, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 2, 124, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Tom & Jerry", "Animation", 18.99f, 3, 90, "John Musker");
        Book book1 = new Book("sach", "tieuthuyet", 12.22f, 4);
        Book book2 = new Book("sach2", "tieuthuyet2", 12.22f, 5);
        CompactDisc cd1 = new CompactDisc("cd1", "category1", 10, 6, "artist1");
        CompactDisc cd2 = new CompactDisc("cd2", "category2", 10, 6, "artist2");
        Track track1 = new Track("baihat1", 180);
        Track track2 = new Track("baihat2", 200);
        Track track3 = new Track("baihat3", 193);
      
        do {
            showMenu();
            int choose = scanner.nextInt();
            switch(choose) {
                case 1:
                    if(Order.getNbOrders() < Order.MAX_LIMITTED_ORDERS) {
                        myOrder[Order.getNbOrders()] = Order.createOrder();
                    }
                    else {
                        System.out.println("Cannot add more order");
                    }
                    break;
                case 2:
                    if(Order.getNbOrders() == 0) {
                        System.out.println("Chua co order nao duoc tao");
                    }
                    else{
                        loop: do {
                            menuItems();
                            int get = scanner.nextInt();
                            switch(get) {
                                case 1: 
                                    // add book
                                    book: do {
                                        menuBook();
                                        int getBook = scanner.nextInt();
                                        switch(getBook) {
                                            case 1:
                                                myOrder[Order.getNbOrders() - 1].addMedia(book1);
                                                break;
                                            case 2:
                                                myOrder[Order.getNbOrders() - 1].addMedia(book2);
                                                break;
                                            case 0: 
                                                break book;
                                            default:
                                                System.out.println("Chon sai");
                                        }
                                    } while(true);
                                    break;
                                case 2: 
                                    // add compactDisc
                                    CD: do {
                                        menuCD();
                                        int getCD = scanner.nextInt();
                                        switch(getCD) {
                                            case 1:
                                                myOrder[Order.getNbOrders() - 1].addMedia(cd1);
                                                track_cd1: do {
                                                    menuTrack();
                                                    int getTrack = scanner.nextInt();
                                                    switch(getTrack) {
                                                        case 1: cd1.addTrack(track1); break;
                                                        case 2: cd1.addTrack(track2); break;
                                                        case 3: cd1.addTrack(track3); break;
                                                        case 0: break track_cd1; 
                                                        default: System.out.println("Chon sai");
                                                    }

                                                } while (true);
                                                askPlayCD(cd1);
                                                break;
                                            case 2:
                                                myOrder[Order.getNbOrders() - 1].addMedia(cd2);
                                                track_cd2: do {
                                                    menuTrack();
                                                    int getTrack = scanner.nextInt();
                                                    switch(getTrack) {
                                                        case 1: cd2.addTrack(track1); break;
                                                        case 2: cd2.addTrack(track2); break;
                                                        case 3: cd2.addTrack(track3); break;
                                                        case 0: break track_cd2; 
                                                        default: System.out.println("Chon sai");
                                                    }
                                                } while (true);
                                                askPlayCD(cd2);
                                                break;
                                            case 0: 
                                                break CD;
                                            default:
                                                System.out.println("Chon sai");
                                        }
                                    } while(true);
                                    break;
                                case 3: 
                                    // add DigitalDisc
                                    DVD: do {
                                        menuDVD();
                                        int getDVD = scanner.nextInt();
                                        switch(getDVD) {
                                            case 1:
                                                myOrder[Order.getNbOrders() - 1].addMedia(dvd1);
                                                askPlayDVD(dvd1);
                                                break;
                                            case 2:
                                                myOrder[Order.getNbOrders() - 1].addMedia(dvd2);
                                                askPlayDVD(dvd2);
                                                break;
                                            case 3:
                                                myOrder[Order.getNbOrders() - 1].addMedia(dvd3);
                                                askPlayDVD(dvd3);
                                                break;
                                            case 0: 
                                                break DVD;
                                            default:
                                                System.out.println("Chon sai");
                                        }
                                    } while(true);
                                    break;
                                case 0:
                                    break loop;
                                default:
                                    System.out.println("Chon sai");
                            }
                        } while (true);
                    } 
                    break;
                case 3:
                    if(Order.getNbOrders() == 0) {
                        System.out.println("Chua co order nao duoc tao");
                    }
                    else {
                        System.out.println("Nhap id can xoa: ");
                        int id = scanner.nextInt();
                        myOrder[Order.getNbOrders() - 1].removeMedia(id);
                    }
                    break;
                case 4:
                    Order.printOrder(myOrder);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chon sai, nhap lai.");
            }
        } while (true);        
    }
}
