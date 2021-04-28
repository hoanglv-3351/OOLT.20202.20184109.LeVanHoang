package hust.soict.hedspi.test.media;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;


import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestMediaCompareTo {

    public static void test() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation",19.95f,1,87,"Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction",24.95f,2,124,"George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin","Animation",18.99f,3,90,"John Musker");

        Collection collection = new ArrayList();
        collection.add(dvd1);
        collection.add(dvd2);
        collection.add(dvd3);

        java.util.Iterator iterator = collection.iterator();

        System.out.println("----------------------------------");
        System.out.println("The DVDs currently in the order are: ");

        while(iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }

        java.util.Collections.sort((java.util.List) collection);
        iterator = collection.iterator();
        System.out.println("----------------------------------");
        System.out.println("The DVDs in sorted order are: ");

        while(iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }
    }

    public static void main(String[] args) {

       test();

    }
}
