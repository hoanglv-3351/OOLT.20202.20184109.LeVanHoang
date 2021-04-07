package hust.soict.hedspi.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NoGarbage {
    public static void main(String[] args) throws FileNotFoundException{
        StringBuilder str = new StringBuilder("");
        File file = new File("C:\\Users\\hoang\\Desktop\\JAVA\\Lab05\\OtherProjects\\src\\text1.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            str.append(scanner.nextLine());
        }
        System.out.println(str);
    }
}
