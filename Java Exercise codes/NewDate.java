// 8.14 A


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewDate {
    private Calendar calendar;

    public NewDate() {
        calendar = Calendar.getInstance();
    }

    public NewDate(int year, int month, int day) {
        calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
    }

    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    public int getMonth() {
        return calendar.get(Calendar.MONTH) + 1;
    }

    public int getDay() {
        return calendar.get(Calendar.DATE);
    }

    public String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(calendar.getTime());
    }

    public String getFormattedDate2() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        return sdf.format(calendar.getTime());
    }

    public String getFormattedDate3() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return sdf.format(calendar.getTime());
    }

    public static void main(String[] args) {
        NewDate date = new NewDate();
        System.out.println(date.getFormattedDate());
        System.out.println(date.getFormattedDate2());
        System.out.println(date.getFormattedDate3());
    }
}