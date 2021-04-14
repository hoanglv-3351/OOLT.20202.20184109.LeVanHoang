package hust.soict.hedspi.aims.utils;


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
        time = myDate.split("\\s++");
        year = Integer.parseInt(time[2]);
        String dd = time[1].substring(0, time[1].length()-2);
        day = Integer.parseInt(dd);
        switch(time[0]){
            case "January": this.setMonth(1); break;
            case "February": this.setMonth(2); break;
            case "March": this.setMonth(3); break;
            case "April": this.setMonth(4); break;
            case "May": this.setMonth(5); break;
            case "June": this.setMonth(6); break;
            case "July": this.setMonth(7); break;
            case "August": this.setMonth(8); break;
            case "September": this.setMonth(9); break;
            case "October": this.setMonth(10); break;
            case "November": this.setMonth(11); break;
            case "December": this.setMonth(12); break;
            default: this.setMonth(0);
        }
    }


    // demo 1 vai nam gan day
    public static String changeToNumber(String year) {
        switch (year) {
            case "eighteen": year = "18"; break;
            case "nineteen": year = "19"; break;
            case "twenty": year = "20"; break;
            case "twenty-one": year = "21"; break;
            case "twenty-two": year = "22"; break;
            case "hundred": year = "00"; break;
            default:
        }
        return year;

    }

    public MyDate(String day, String month, String year) {
        switch (day){
            case "first": this.setDay(1); break;
            case "second": this.setDay(2); break;
            case "third": this.setDay(3); break;
            case "fourth": this.setDay(4); break;
            case "fifth": this.setDay(5); break;
            case "sixth": this.setDay(6); break;
            case "seventh": this.setDay(7); break;
            case "eighth": this.setDay(8); break;
            case "ninth": this.setDay(9); break;
            case "tenth": this.setDay(10); break;
            case "eleventh": this.setDay(11); break;
            case "twelfth": this.setDay(12); break;
            case "thirteenth": this.setDay(13); break;
            case "fourteenth": this.setDay(14); break;
            case "fifteenth": this.setDay(15); break;
            case "sixteenth": this.setDay(16); break;
            case "seventeenth": this.setDay(17); break;
            case "eighteenth": this.setDay(18); break;
            case "nineteenth": this.setDay(19); break;
            case "twentieth": this.setDay(20); break;
            case "twenty-first": this.setDay(21); break;
            case "twenty-second": this.setDay(22); break;
            case "twenty-third": this.setDay(23); break;
            case "twenty-fourth": this.setDay(24); break;
            case "twenty-fifth": this.setDay(25); break;
            case "twenty-sixth": this.setDay(26); break;
            case "twenty-seventh": this.setDay(27); break;
            case "twenty-eighth": this.setDay(28); break;
            case "twenty-ninth": this.setDay(29); break;
            case "thirtieth": this.setDay(30); break;
            case "thirty-first": this.setDay(31); break;
            default: this.setDay(0);
        }

        switch (month){
            case "January": this.setMonth(1); break;
            case "February": this.setMonth(2); break;
            case "March": this.setMonth(3); break;
            case "April": this.setMonth(4); break;
            case "May": this.setMonth(5); break;
            case "June": this.setMonth(6); break;
            case "July": this.setMonth(7); break;
            case "August": this.setMonth(8); break;
            case "September": this.setMonth(9); break;
            case "October": this.setMonth(10); break;
            case "November": this.setMonth(11); break;
            case "December": this.setMonth(12); break;
            default: this.setMonth(0);
        }

        String[] yy = year.split("\\s");
        yy[0] = changeToNumber(yy[0]);
        yy[1] = changeToNumber(yy[1]);

        year = yy[0] + yy[1];
        this.setYear(Integer.parseInt(year));
    }


    public void accept(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a date:(dd/MM/yyyy)");
        String inputDate = keyboard.nextLine();
        time = inputDate.split("/");
        day = Integer.parseInt(time[0]);
        if(day < 0 || day > 31){
            System.out.println("Invalid day");
            System.exit(0);
        }
        month = Integer.parseInt(time[1]);
        if(month < 0 || month > 12){
            System.out.println("Invalid month");
            System.exit(0);
        }
        year = Integer.parseInt(time[2]);
        if(year < 0){
            System.out.println("Invalid year");
            System.exit(0);
        }
        keyboard.close();
    }

    public static void today(){
        Calendar cal = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	String tam;
    	tam= sdf.format(cal.getTime());
        System.out.println("Today is " + tam);
        System.out.println();
    }

    public static void print (MyDate date) {
        String dayPlus;
        String mm;
        switch (date.getMonth()) {
            case 1: mm = "January"; break;
            case 2: mm = "February"; break;
            case 3: mm = "March"; break;
            case 4: mm = "April"; break;
            case 5: mm = "May"; break;
            case 6: mm = "June"; break;
            case 7: mm = "July"; break;
            case 8: mm = "August"; break;
            case 9: mm = "September"; break;
            case 10: mm = "October"; break;
            case 11: mm = "November"; break;
            case 12: mm = "December"; break;
            default: mm = "";
        }
        switch(date.getDay()) {
            case 1: case 21: case 31:
                dayPlus = "st";
                break;
            case 2: case 22: 
                dayPlus = "nd";
                break;
            case 3: case 23:
                dayPlus = "rd";
                break;
            default:
                dayPlus = "th";
        }
        System.out.println(mm + " " + date.getDay() + dayPlus + " " + date.getYear());
    }

    public static void selfPrint(MyDate date) {
        System.out.println(date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
    }
    public static void main(String[] args){
        System.out.println("ok");
    }
}