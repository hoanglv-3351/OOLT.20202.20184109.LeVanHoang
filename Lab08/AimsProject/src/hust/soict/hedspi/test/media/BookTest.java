package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.Book;

public class BookTest {
    public static void main(String[] args){
        Book b = new Book("Lorem","automatic",40.32f,1);
        b.setContent("There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour.\n" 
                    +"\n" 
                    + "If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.\n" +
                "\n" +
                "All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet.\n" +
                "\n" +
                "It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable.\n" +
                "\n" +
                "The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.\n") ;
        System.out.println(b.toString());
    }
}
