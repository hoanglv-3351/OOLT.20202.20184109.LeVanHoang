import java.util.ArrayList;
import java.util.Scanner;

public class Aims {
    static Scanner scanner = new Scanner(System.in);    
    public static Order unitTestAdd1(Order myOrder) {
        myOrder = new Order();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCategory("Animation");
        dvd1.setDirector("Roger Allers");
        dvd1.setLength(87);
        dvd1.setCost(19.95f);
        myOrder.addDigitalVideoDisc(dvd1);
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
        myOrder.addDigitalVideoDisc(dvd1, dvd2);
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
        myOrder.addDigitalVideoDisc(dvdList);
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
        myOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3, dvd3, dvd2, dvd1);
        System.out.println("Total cost is: " + myOrder.totalCost());
        System.out.println("---------------------------");
        return myOrder;
    }

    public static void main(String[] args){

        Order [] myOrder = new Order[Order.MAX_LIMITTED_ORDERS];
        myOrder[0] = Aims.unitTestAdd1(myOrder[0]);
        myOrder[1] = Aims.unitTestAdd2(myOrder[1]);
        myOrder[2] = Aims.unitTestAddSome(myOrder[2]);
        // myOrder[3] = Aims.unitTestAddArr(myOrder[3]);
        // System.out.println(Order.getNbOrders());
        System.out.println(Order.getNbOrders());
        Order.printOrder(myOrder);

    }
    
}
