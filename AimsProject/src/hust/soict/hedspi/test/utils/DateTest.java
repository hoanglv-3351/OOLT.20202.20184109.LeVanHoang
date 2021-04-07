package hust.soict.hedspi.test.utils;

import hust.soict.hedspi.aims.utils.*;

public class DateTest {

   public static MyDate unitTest_0para() {
      MyDate d1 = new MyDate();
        System.out.println("day: "+ d1.getDay());
        System.out.println("month: " + d1.getMonth());
        System.out.println("year: " + d1.getYear());
        System.out.println("-------------------");
        return d1;
   }

   public static MyDate unitTest_1StrPara(){
      MyDate d2 = new MyDate("August 4th           2000");
      System.out.println("day: "+ d2.getDay());
      System.out.println("month: " + d2.getMonth());
      System.out.println("year: " + d2.getYear());
      System.out.println("-------------------");
      return d2;
   }

   public static MyDate unitTest_3intPara() {
      MyDate d3 = new MyDate(4, 8, 2000);
      System.out.println("day: "+ d3.getDay());
      System.out.println("month: " + d3.getMonth());
      System.out.println("year: " + d3.getYear());
      System.out.println("--------------------");
      return d3;
   }

   public static MyDate unitTest_3strPara() {
      MyDate d4 = new MyDate("eighth", "August", "twenty twenty-one");
        System.out.println("day: "+ d4.getDay());
        System.out.println("month: " + d4.getMonth());
        System.out.println("year: " + d4.getYear());
        System.out.println("------------------------");
        return d4;
   }

   public static MyDate unitTest_inputDate() {
      MyDate dateTest = new MyDate();
      dateTest.accept();
      System.out.println("day: "+ dateTest.getDay());
      System.out.println("month:" + dateTest.getMonth());
      System.out.println("year: " + dateTest.getYear());
      System.out.println("----------------------------");
      return dateTest;
   }



   public static void main(String args[]) {  
      //print today
      MyDate.today();
      MyDate dateList[] = new MyDate[5];

      // create date by 0 para
      dateList[0] = DateTest.unitTest_0para();
      // create date by 3 int para
      dateList[1] = DateTest.unitTest_3intPara();
      // create date by 1 string para
      dateList[2] = DateTest.unitTest_1StrPara();

      // create date by 3 string para
      // eighth, August, twenty twenty-one
      dateList[3] = DateTest.unitTest_3strPara();
      
      // create date by input from keyboard
      dateList[4] = DateTest.unitTest_inputDate();

      // sort date list
      DateUtils.sortDates(dateList);
      System.out.println("Sorted list: ");
      for(int i=0 ; i<dateList.length ; i++) {
         MyDate.selfPrint(dateList[i]);
      }

      System.out.print("Ngay som nhat: ");
      MyDate.print(dateList[0]);
      System.out.print("Ngay muon nhat: ");
      MyDate.selfPrint(dateList[4]);
   }
}