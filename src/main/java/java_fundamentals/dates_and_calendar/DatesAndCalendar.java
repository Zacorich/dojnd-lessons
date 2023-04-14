package java_fundamentals.dates_and_calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatesAndCalendar {
    public static void main(String[] args) {
        displayCurrentDate();
        displaySetDate();
    }
    public static void displayCurrentDate(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        Date date  = new Date();
        calendar.setTime(date);
        System.out.println(calendar.getTime());
    }

    public static void displaySetDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2031, 02, 02);
        Date date  = calendar.getTime();
        System.out.println(date);
        //format date
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(date));
    }
}
