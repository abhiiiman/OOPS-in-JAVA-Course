// 8.7

public class Date {
    private int month;
    private int day;
    private int year;

    private static final int[] daysPerMonth = 
    { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public Date(int month, int day, int year) {
        if (month <= 0 || month > 12)
            throw new IllegalArgumentException("month (" + month + ") must be 1-12");

        if (day <= 0 || 
            (day > daysPerMonth[month] && !(month == 2 && day == 29)))
            throw new IllegalArgumentException("day (" + day + 
                ") out-of-range for the specified month and year");

        if (year < 1800 || year > 9999)
            throw new IllegalArgumentException("year (" + year + ") must be 1800-9999");

        this.month = month;
        this.day = day;
        this.year = year;
    }
    
    public void nextDay() {
        if (day < daysPerMonth[month]) {
            day++;
        } else {
            if (month == 2 && day == 28 && !isLeapYear()) {
                day++;
            } else if (month == 12) {
                day = 1;
                month = 1;
                year++;
            } else {
                day = 1;
                month++;
            }
        }
    }

    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }

    private boolean isLeapYear() {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {
        Date date = new Date(12, 31, 2020);
        System.out.println("Initial date: " + date);
        for (int i = 1; i <= 365; i++) {
            date.nextDay();
            System.out.println("Next day: " + date);
        }
    }
}
