package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.order.*;

public class DiskTest {

    public static Order addDVD() {
        Order myOrder = new Order();
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
        myOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3, dvd3, dvd2, dvd1);
        System.out.println("Total cost is: " + myOrder.totalCost());
        System.out.println("---------------------------");
        return myOrder;
    }

    public static void unitTestSearch(Order myOrder) {
        boolean contains = false;
        String name = "king lion the one";
        for (int i=0; i<myOrder.getQtyOrdered(); i++) {
            if (myOrder.getItemOrdered()[i].search(name) == true) {
                contains = true;
            }
        }
        if (contains) {
            System.out.println("This order contains dvd you are finding");
        }
        else {
            System.out.println("This order do not contain dvd you are finding");
        }
    }

    public static void unitTestLuckyItem(Order myOrder) {
        DigitalVideoDisc luckyDVD = Order.getALuckyItem(myOrder);
        if(luckyDVD != null) {
            System.out.println("you are lucky, you got discount of the dvd " + luckyDVD.getTitle());
            System.out.println("you got discount of $"+ luckyDVD.getCost());
            System.out.println("now you have to pay total $" + (myOrder.totalCost() - luckyDVD.getCost()));
            System.out.println("-----------------------------------");
        }
        else {
            System.out.println("you are not lucky this time");
        }
    }

    public static void main(String[] args){
        Order myOrder = addDVD();
        unitTestLuckyItem(myOrder);
        unitTestSearch(myOrder);
    }
}


