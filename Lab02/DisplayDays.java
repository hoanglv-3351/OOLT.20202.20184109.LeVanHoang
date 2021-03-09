import java.util.Scanner;


public class DisplayDays {
    public static void main(String[] args){
        System.out.print("Enter month: ");
        Scanner keyboard = new Scanner(System.in);
        String month = keyboard.nextLine();
        // month = month.toLowerCase();

        int leapYear = 0;
        
        
        System.out.print("Enter year: ");
        int year = keyboard.nextInt();

        while(year < 0){
            System.out.print("Invalid year, enter again: ");
            year = keyboard.nextInt();
        }

        if(year%4 == 0){
            if(year%100 != 0 | year%400 == 0){
                leapYear = 1;
            }
            else leapYear = 0;
        }
        int running;
        do{
            running = 0;
            switch(month){
                case "1": case "Jan": case "Jan.":
                case "January":
                    month = "January";
                    System.out.println(year + ", " + month + " has 31 days.");
                    break;
                case "2": case "Feb": case "Feb.":
                case "February":
                    month = "February";
                    if(leapYear == 1){
                        System.out.println(year + ", " + month + " has 29 days.");
                    }
                    else System.out.println(year + ", " + month + " has 28 days.");
                    
                    break;
                case "3": case "Mar": case "Mar.":
                case "March":
                    month = "March";
                    System.out.println(year + ", " + month + " has 31 days.");
                    break;
                case "4": case "Apr": case "Apr.":
                case "April":
                    month = "April";
                    System.out.println(year + ", " + month + " has 30 days.");
                    break;
                case "5":
                case "May":
                    month = "May";
                    System.out.println(year + ", " + month + " has 31 days.");
                    break;
                case "6":
                case "June":
                    month = "June";
                    System.out.println(year + ", " + month + " has 30 days.");
                    break;
                case "7": 
                case "July":
                    month = "July";
                    System.out.println(year + ", " + month + " has 31 days.");
                    break;
                case "8": case "Aug": case "Aug.":
                case "August":
                    month = "August";
                    System.out.println(year + ", " + month + " has 31 days.");
                    break;
                case "9": case "Sep": case "Sep.":
                case "September":
                    month = "September";
                    System.out.println(year + ", " + month + " has 30 days.");
                    break;
                case "10": case "Oct": case "Oct.":
                case "October":
                    month = "October";
                    System.out.println(year + ", " + month + " has 31 days.");
                    break;
                case "11": case "Nov": case "Nov.":
                case "November":
                    month = "November";
                    System.out.println(year + ", " + month + " has 30 days.");
                    break;
                case "12": case "Dec": case "Dec.":
                case "December":
                    month = "December";
                    System.out.println(year + ", " + month + " has 31 days.");
                    break;
                default:
                    System.out.print("Invalid month, enter again: ");
                    month = keyboard.nextLine();
                    running = 1;
                    break;
            }
        }
        while(running == 1);


    }
}
