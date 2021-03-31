package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.utils.*;

public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    public static final int MAX_LIMITTED_ORDERS = 5;
    private static int nbOrders = 0;

    private int qtyOrdered = 0;
    private double total = 0;
    private MyDate dateOrdered;
    
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    
    public static int getNbOrders() {
        return nbOrders;
    }

    public Order() {
        dateOrdered = new MyDate();
        nbOrders++;
    }

    public static Order createOrder(){
        if(nbOrders < 5) {
            // dateOrdered = new MyDate();
            Order myOrder = new Order();
            System.out.println(nbOrders);
            return myOrder;
        }
        else {
            System.out.println("Cannot create more order!!");
            return null;
        }
    }

    public int getQtyOrdered(){
        return qtyOrdered;
    }

    public DigitalVideoDisc[] getItemOrdered(){
        return itemOrdered;
    }


    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered < MAX_NUMBERS_ORDERED){
            System.out.println("DVD " + disc.getTitle() + " has been added.");
            itemOrdered[qtyOrdered] = disc;
            total += disc.getCost();
            qtyOrdered ++;
        }
        else{
            System.out.println("The order is already full");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        if(qtyOrdered < MAX_NUMBERS_ORDERED){
            System.out.println("DVD " + disc1.getTitle() + " has been added.");
            itemOrdered[qtyOrdered] = disc1;
            total += disc1.getCost();
            qtyOrdered ++;
            if(qtyOrdered < MAX_NUMBERS_ORDERED){
                System.out.println("DVD " + disc2.getTitle() + " has been added.");
                itemOrdered[qtyOrdered] = disc2;
                total += disc2.getCost();
                qtyOrdered ++;
            }
            else{
                System.out.println("DVD " + disc2.getTitle() + " could not be added");
            }
        }
        else{
            System.out.println("The item quantity has reached its limit");
        }
        
    }

    // public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){

    //     if(dvdList != null) {
    //         if(dvdList.length > (MAX_NUMBERS_ORDERED - qtyOrdered)){
    //             System.out.println("Not enough space, could not add this list. Check again.");
    //         }
    //         else{
    //             for(DigitalVideoDisc disc: dvdList){
    //                 // addDigitalVideoDisc(disc);
    //                 System.out.println("DVD " + disc.getTitle() + " has been added.");
    //                 itemOrdered[qtyOrdered] = disc;
    //                 total += disc.getCost();
    //                 qtyOrdered ++;
    //             }
    //         }
    //     }
    //     else {
    //         System.out.println("You are trying to add an empty list. Try again.");
    //     }
    // }

    public void addDigitalVideoDisc(DigitalVideoDisc ...arr) {
        if(arr != null){
            if(arr.length > 0) {
                int i;
                for(i = 0 ; i < arr.length ; i++) {
                    if(qtyOrdered < MAX_NUMBERS_ORDERED){
                        System.out.println("DVD " + arr[i].getTitle() + " has been added.");
                        itemOrdered[qtyOrdered] = arr[i];
                        total += arr[i].getCost();
                        qtyOrdered ++;
                    }
                    else break;
                }
                for(int j = i; j < arr.length ; j++){
                    System.out.println("DVD " + arr[j].getTitle() + " could not be added");
                }
            }
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        if(itemOrdered == null){
            System.out.println("order is null");
        }
        else{
            for(int i = qtyOrdered - 1; i > -1 ; i--){
                if(itemOrdered[i] == disc){
                    total -= disc.getCost();
                    for(int j = i ; j<qtyOrdered - 2; j++){
                        itemOrdered[j] = itemOrdered[j+1];
                    }
                    itemOrdered[qtyOrdered-1]=null;
                    qtyOrdered -= 1;
                    System.out.println("Remove DVD " + disc.getTitle() + " successfully");
                    break;
                }
                if(i == 0 && itemOrdered[i] != disc){
                    System.out.println("This disc is not in order");
                }
            }
        }
    }

    public static void printOrder(Order [] myOrders) {
        System.out.println("****************Order*********************");
        System.out.println(nbOrders);
        for(int i=0 ; i<nbOrders ; i++) {
            myOrders[i].getDateOrdered();
            System.out.println("Order " + " items: ");
            for(int j=0 ; j<myOrders[i].qtyOrdered ; j++) {
                System.out.println((j+1) + ". DVD - " + myOrders[i].itemOrdered[j].getTitle() + " - " + 
                myOrders[i].itemOrdered[j].getCategory() + " - " +
                myOrders[i].itemOrdered[j].getDirector() + " - " + 
                myOrders[i].itemOrdered[j].getLength() + ": " + 
                myOrders[i].itemOrdered[j].getCost() + "$" );
            }
            System.out.println("Total cost: " + myOrders[i].totalCost());
            System.out.println("****************************************");
        }
    }


    public double totalCost(){
        return Math.round(total*100)/100.0;
    }

    public void getDateOrdered() {
        System.out.println("Date: " + dateOrdered.getDay() + "/" + dateOrdered.getMonth() + "/" + dateOrdered.getYear() );
    }

    public static DigitalVideoDisc getALuckyItem(Order myOrder) {
        int max = 9;
        int min = 0;
        int range = max - min + 1;
        int i = (int)(Math.random() * range) + min;
        if(i < myOrder.getQtyOrdered()) {
            return myOrder.getItemOrdered()[i];
        }
        else {
            return null;
        }
    }
}
