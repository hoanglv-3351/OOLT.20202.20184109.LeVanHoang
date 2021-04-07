package hust.soict.hedspi.aims.order;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.utils.*;



public class Order {
    public static final int MAX_LIMITTED_ORDERS = 5;
    private static int nbOrders = 0;

    private double total = 0;
    private MyDate dateOrdered;
    
    private ArrayList<Media> itemOrdered = new ArrayList<Media>();
    
    public static int getNbOrders() {
        return nbOrders;
    }

    public Order() {
        dateOrdered = new MyDate();
        nbOrders++;
    }

    public static Order createOrder(){
        if(nbOrders < 5) {
            Order myOrder = new Order();
            System.out.println("Successfully create new order");
            return myOrder;
        }
        else {
            System.out.println("Cannot create more order!!");
            return null;
        }
    }

    public void addMedia(Media md){
        System.out.println("DVD " + md.getTitle() + " has been added.");
        itemOrdered.add(md);
        total += md.getCost();
    }

    public void addMedia(Media md1, Media md2) {
        System.out.println("DVD " + md1.getTitle() + " has been added.");
        itemOrdered.add(md1);
        total += md1.getCost();
        System.out.println("DVD " + md2.getTitle() + " has been added.");
        itemOrdered.add(md2);
        total += md2.getCost();
    }

    // public void addMedia(Media [] mdList){
    //     if(dvdList != null) {
    //         for(Media md: mdList){
    //             System.out.println("Media " + md.getTitle() + " has been added.");
    //             itemOrdered.add(md);
    //             total += md.getCost();
    //         }
    //     }
    //     else {
    //         System.out.println("You are trying to add an empty list. Try again.");
    //     }
    // }

    public void addMedia(Media ...arr) {
        if(arr != null){
            if(arr.length > 0) {
                int i;
                for(i = 0 ; i < arr.length ; i++) {
                    System.out.println("Media " + arr[i].getTitle() + " has been added.");
                    itemOrdered.add(arr[i]);
                    total += arr[i].getCost();
                }
            }
        }
    }

    public void removeMedia(int id){
        if(itemOrdered == null){
            System.out.println("order is null");
        }
        else{
            for(int i = itemOrdered.size() - 1; i > -1 ; i--){
                if(itemOrdered.get(i).getId() == id){
                    total -= itemOrdered.get(i).getCost();
                    itemOrdered.remove(i);
                    System.out.println("Remove Media " + itemOrdered.get(i).getTitle() + " successfully");
                    break;
                }
                if(i == 0 && itemOrdered.get(i).getId() != id){
                    System.out.println("This media is not in order");
                }
            }
        }
    }

    public static void printOrder(Order [] myOrders) {
        System.out.println("****************Order*********************");
        System.out.println(nbOrders);
        for(int i=0 ; i<nbOrders ; i++) {
            if(myOrders[i] != null){
                myOrders[i].getDateOrdered();
                System.out.println("Order " + " items: ");
                for(int j=0 ; j<myOrders[i].itemOrdered.size() ; j++) {
                    if(myOrders[i].itemOrdered.get(j) instanceof DigitalVideoDisc){
                        System.out.println((j+1) + ". DVD - " + myOrders[i].itemOrdered.get(j).getTitle() + " - " + 
                        myOrders[i].itemOrdered.get(j).getCategory() + " - " +
                        ((DigitalVideoDisc) myOrders[i].itemOrdered.get(j)).getDirector() + " - " + 
                        ((DigitalVideoDisc) myOrders[i].itemOrdered.get(j)).getLength() + ": " + 
                        myOrders[i].itemOrdered.get(j).getCost() + "$" );
                    }
                    else {
                        System.out.println((j+1) + ". Book - " + myOrders[i].itemOrdered.get(j).getTitle() + " - " + 
                        myOrders[i].itemOrdered.get(j).getCategory() + " - " +
                        myOrders[i].itemOrdered.get(j).getCost() + "$" );
                    }
                }
                System.out.println("Total cost: " + myOrders[i].totalCost());
                System.out.println("****************************************");
            }
            
        }
    }


    public double totalCost(){
        return Math.round(total*100)/100.0;
    }

    public void getDateOrdered() {
        System.out.println("Date: " + dateOrdered.getDay() + "/" + dateOrdered.getMonth() + "/" + dateOrdered.getYear() );
    }

    public static Media getALuckyItem(Order myOrder) {
        int max = 9;
        int min = 0;
        int range = max - min + 1;
        int i = (int)(Math.random() * range) + min;
        if(i < myOrder.itemOrdered.size()) {
            return myOrder.itemOrdered.get(i);
        }
        else {
            return null;
        }
    }

    public void setDateOrdered(MyDate dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public ArrayList<Media> getItemOrdered() {
        return itemOrdered;
    }

    public void setItemOrdered(ArrayList<Media> itemOrdered) {
        this.itemOrdered = itemOrdered;
    }

}
