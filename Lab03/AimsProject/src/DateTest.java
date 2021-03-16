 
public class DateTest {
   public static void main(String args[]) {
        MyDate d1 = new MyDate();
        System.out.println("day: "+ d1.getDay());
        System.out.println("month: " + d1.getMonth());
        System.out.println("year: " + d1.getYear());
        System.out.println();
        
        MyDate d2 = new MyDate(4, 8, 2000);
        System.out.println("day: "+ d2.getDay());
        System.out.println("month: " + d2.getMonth());
        System.out.println("year: " + d2.getYear());
        System.out.println();

        MyDate d3 = new MyDate("August 4th 2000");
        System.out.println("day: "+ d3.getDay());
        System.out.println("month: " + d3.getMonth());
        System.out.println("year: " + d3.getYear());
        System.out.println();

        MyDate.print();

        MyDate dateTest = new MyDate();
        dateTest.accept();
        System.out.println("day: "+ dateTest.getDay());
        System.out.println("month:" + dateTest.getMonth());
        System.out.println("year: " + dateTest.getYear());
        System.out.println();
   }
}