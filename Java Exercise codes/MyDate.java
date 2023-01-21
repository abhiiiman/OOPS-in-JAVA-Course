// 8.14 B

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyDate {
    private Calendar calendar;

    // no-arg constructor that initializes the date to the current date
    public MyDate() {
        calendar = Calendar.getInstance();
    }

    // constructor that initializes the date to a specified date in the format MM/DD/YYYY
    public MyDate(int month, int day, int year) {
        calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
    }

    // constructor that initializes the date to a specified date in the format June 14, 1992
    public MyDate(String month, int day, int year) throws ParseException {
        calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        java.util.Date date = sdf.parse(month + " " + day + ", " + year);
        calendar.setTime(date);
    }

    // constructor that initializes the date to a specified date in the format 14 June 1992
    public MyDate(int day, String month, int year) throws ParseException {
        calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        java.util.Date utilDate = sdf.parse(day + " " + month + " " + year);
        calendar.setTime(utilDate);
    }

    // getter for the year
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    // getter for the month
    public int getMonth() {
        return calendar.get(Calendar.MONTH) + 1;
    }

    // getter for the day
    public int getDay() {
        return calendar.get(Calendar.DATE);
    }

    // method to output the date in the format MM/DD/YYYY
    public String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(calendar.getTime());
    }

    // method to output the date in the format June 14, 1992
    public String getFormattedDate2() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        return sdf.format(calendar.getTime());
    }

    // method to output the date in the format 14 June 1992
    public String getFormattedDate3() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return sdf.format(calendar.getTime());
    }

    public static void main(String[] args) throws ParseException {
        MyDate date1 = new MyDate(6, 14, 1992);
        System.out.println(date1.getFormattedDate());
        System.out.println(date1.getFormattedDate2());
        System.out.println(date1.getFormattedDate3());
        System.out.println();

        MyDate date2 = new MyDate("June", 14, 1992);
        System.out.println(date2.getFormattedDate());
        System.out.println(date2.getFormattedDate2());
        System.out.println(date2.getFormattedDate3());
        System.out.println();

        MyDate date3 = new MyDate(14, "June", 1992);
        System.out.println(date3.getFormattedDate());
        System.out.println(date3.getFormattedDate2());
        System.out.println(date3.getFormattedDate3());
    }
}