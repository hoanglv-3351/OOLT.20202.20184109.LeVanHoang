package hust.soict.hedspi.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GarbageCreator {
    public static void main(String[] args) throws FileNotFoundException{
        String str = "";
        File file = new File("C:\\Users\\hoang\\Desktop\\JAVA\\Lab05\\OtherProjects\\src\\text1.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            str += scanner.nextLine();
        }
        System.out.println(str);
    }
}
