package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.order.*;

public class DiskTest {

    public static Order addDVD() {
        Order myOrder = new Order();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 1, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 2, 124, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Tom & Jerry", "Animation", 18.99f, 3, 90, "John Musker");
        myOrder.addMedia(dvd1, dvd2, dvd3, dvd3, dvd2, dvd1);
        System.out.println("Total cost is: " + myOrder.totalCost());
        System.out.println("---------------------------");
        return myOrder;
    }

    public static void unitTestSearch(Order myOrder) {
        boolean contains = false;
        String name = "king lion the one";
        for (int i=0; i<myOrder.getItemOrdered().size(); i++) {
            if (myOrder.getItemOrdered().get(i).search(name) == true) {
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
        Media luckyDVD = Order.getALuckyItem(myOrder);
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


