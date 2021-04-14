package hust.soict.hedspi.aims.utils;

public class DateUtils {
    public static int compare(MyDate d1, MyDate d2){
        if(d1.getYear() > d2.getYear()){
            return 1;
        }
        else if (d1.getYear() < d2.getYear()) {
            return 0;
        }
        else {
            if(d1.getMonth() > d2.getMonth()) {
                return 1;
            }
            else if(d1.getMonth() < d2.getMonth()) {
                return 0;
            }
            else {
                if (d1.getDay() > d2.getDay()) {
                    return 1;
                }
                else return 0;
            }
        }
    }

    public static void sortDates (MyDate []dateList) {
        for(int i=0 ; i<dateList.length ; i++) {
            for (int j=i+1 ; j<dateList.length ; j++) {
                if (DateUtils.compare(dateList[i], dateList[j]) > 0) {
                    MyDate temp = dateList[i];
                    dateList[i] = dateList[j];
                    dateList[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        MyDate [] date = new MyDate[3];
        date[0] = new MyDate("September 20th 2000");
        date[1] = new MyDate();
        date[2] = new MyDate(23,11,2000);
        DateUtils.sortDates(date);
        for (int i=0 ; i< date.length ; i++) {
            System.out.println(date[i].getDay() + " " + date[i].getMonth() + " " + date[i].getYear());
        }
        
    }
}
