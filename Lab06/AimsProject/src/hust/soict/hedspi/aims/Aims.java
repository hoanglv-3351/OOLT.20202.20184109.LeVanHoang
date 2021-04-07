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

    public static Order unitTestAdd1(Order myOrder) {
        myOrder = new Order();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCategory("Animation");
        dvd1.setDirector("Roger Allers");
        dvd1.setLength(87);
        dvd1.setCost(19.95f);
        myOrder.addMedia(dvd1);
        System.out.println("Total cost is: " + myOrder.totalCost());
        System.out.println("---------------------------");
        return myOrder;
    }

    public static Order unitTestAdd2(Order myOrder) {
        myOrder = new Order();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCategory("Animation");
        dvd1.setDirector("Roger Allers");
        dvd1.setLength(87);
        dvd1.setCost(19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        dvd2.setCategory("Science Fiction");
        dvd2.setDirector("George Lucas");
        dvd2.setLength(124);
        dvd2.setCost(24.95f);
        myOrder.addMedia(dvd1, dvd2);
        System.out.println("Total cost is: " + myOrder.totalCost());
        System.out.println("---------------------------");
        return myOrder;
    }

    public static Order unitTestAddArr(Order myOrder) {
        myOrder = new Order();
        DigitalVideoDisc [] dvdList = new DigitalVideoDisc[3];
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCategory("Animation");
        dvd1.setDirector("Roger Allers");
        dvd1.setLength(87);
        dvd1.setCost(19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        dvd2.setCategory("Science Fiction");
        dvd2.setDirector("George Lucas");
        dvd2.setLength(124);
        dvd2.setCost(24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Tom & Jerry");
        dvd3.setCategory("Animation");
        dvd3.setDirector("John Musker");
        dvd3.setLength(90);
        dvd3.setCost(18.99f);
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
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCategory("Animation");
        dvd1.setDirector("Roger Allers");
        dvd1.setLength(87);
        dvd1.setCost(19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        dvd2.setCategory("Science Fiction");
        dvd2.setDirector("George Lucas");
        dvd2.setLength(124);
        dvd2.setCost(24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Tom & Jerry");
        dvd3.setCategory("Animation");
        dvd3.setDirector("John Musker");
        dvd3.setLength(90);
        dvd3.setCost(18.99f);
        Book sach = new Book("sach");
        sach.addAuthor("tacgia1");
        sach.addAuthor("tacgia2");
        sach.setCost(12.22f);
        sach.setCategory("tieuthuyet");
        myOrder.addMedia(dvd1, dvd2, dvd3, dvd3, dvd2, dvd1, sach);
        System.out.println("Total cost is: " + myOrder.totalCost());
        System.out.println("---------------------------");
        return myOrder;
    }

    public static void main(String[] args){
        Order [] myOrder = new Order[Order.MAX_LIMITTED_ORDERS];
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCategory("Animation");
        dvd1.setDirector("Roger Allers");
        dvd1.setLength(87);
        dvd1.setCost(19.95f);
        dvd1.setId(1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        dvd2.setCategory("Science Fiction");
        dvd2.setDirector("George Lucas");
        dvd2.setLength(124);
        dvd2.setCost(24.95f);
        dvd2.setId(2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Tom & Jerry");
        dvd3.setCategory("Animation");
        dvd3.setDirector("John Musker");
        dvd3.setLength(90);
        dvd3.setCost(18.99f);
        dvd3.setId(3);
        Book sach = new Book("sach");
        sach.addAuthor("tacgia1");
        sach.addAuthor("tacgia2");
        sach.setCost(12.22f);
        sach.setCategory("tieuthuyet");
        sach.setId(4);
      
        do {
            showMenu();
            int choose = scanner.nextInt();
            switch(choose) {
                case 1:
                    myOrder[Order.getNbOrders()] = Order.createOrder();
                    break;
                case 2:
                    if(Order.getNbOrders() > 0 && myOrder[Order.getNbOrders() - 1] != null) {
                        System.out.println("Chon media muon them: ");
                        System.out.println("1. DVD1");
                        System.out.println("2. DVD2");
                        System.out.println("3. DVD3");
                        System.out.println("4. book");
                        System.out.println("0. back");
                        loop: do {
                            String str = scanner.nextLine();
                            switch(str) {
                                case "1": 
                                    myOrder[Order.getNbOrders() - 1].addMedia(dvd1);
                                    break;
                                case "2": 
                                    myOrder[Order.getNbOrders() - 1].addMedia(dvd2);
                                    break;
                                case "3": 
                                    myOrder[Order.getNbOrders() - 1].addMedia(dvd3);
                                    break;
                                case "4": 
                                    myOrder[Order.getNbOrders() - 1].addMedia(sach);
                                    break;
                                case "0":
                                    break loop;
                                default:
                                    System.out.println("Chon sai");
                            }
                        } while (true);
                    } else {
                        System.out.println("Chua co order duoc tao");
                    }
                    break;
                case 3:
                    if(Order.getNbOrders() > 0 && myOrder[Order.getNbOrders() - 1] != null) {
                        System.out.println("Nhap id can xoa: ");
                        int id = scanner.nextInt();
                        myOrder[Order.getNbOrders() - 1].removeMedia(id);
                    } else if(Order.getNbOrders() == 0){
                        System.out.println("Chua co order duoc tao");
                    }
                    else {
                        System.out.println("Order rong");
                    }
                    break;
                case 4:
                    Order.printOrder(myOrder);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    // scanner.nextLine();
                    System.out.println("Chon sai, nhap lai.");
            }
        } while (true);        
    }
}
