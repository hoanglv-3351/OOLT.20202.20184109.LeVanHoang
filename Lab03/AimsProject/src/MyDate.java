import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class MyDate {
    private int day; // dd
    private int month; // mm
    private int year; // yyyy
    
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(day > 0 && day < 32){
            this.day = day;
        }
        else{
            System.out.println("Invalid day");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(month > 0 && month < 13){
            this.month = month;
        }
        else{
            System.out.println("Invalid month");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year > 0){
            this.year = year;
        }
        else{
            System.out.println("Invalid year");
        } 
    }   


    Calendar cal = Calendar.getInstance();

    // 0 parameter
    public MyDate(){
        day = cal.getTime().getDate();
        month = cal.getTime().getMonth() + 1;
        year = cal.getTime().getYear() + 1900;
    }

    // 3 parameters
    public MyDate(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    String []time;
    // 1 String parameter
    public MyDate(String myDate){
        time = myDate.split("\\s");
        year = Integer.parseInt(time[2]);
        String dd = time[1].substring(0, time[1].length()-2);
        day = Integer.parseInt(dd);
        switch(time[0]){
            case "January": month = 1; break;
            case "February": month = 2; break;
            case "March": month = 3; break;
            case "April": month = 4; break;
            case "May": month = 5; break;
            case "June": month = 6; break;
            case "July": month = 7; break;
            case "August": month = 8; break;
            case "September": month = 9; break;
            case "October": month = 10; break;
            case "November": month = 11; break;
            case "December": month = 12; break;
            default: month = 0;
        }
    }

    public void accept(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a date:(dd/MM/yyyy)");
        String inputDate = keyboard.nextLine();
        String time[] = inputDate.split("/");
        day = Integer.parseInt(time[0]);
        if(day < 0 || day > 31){
            System.out.println("Invalid day");
            day = 0;
        }
        month = Integer.parseInt(time[1]);
        if(month < 0 || month > 12){
            System.out.println("Invalid month");
            month = 0;
        }
        year = Integer.parseInt(time[2]);
        if(year < 0){
            System.out.println("Invalid year");
            year = 0;
        }
    }

    public static void print(){
        Calendar cal = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	String tam;
    	tam= sdf.format(cal.getTime());
        System.out.println("Today is " + tam);
        System.out.println();
    }
    public static void main(String[] args){
        
    }

    

}