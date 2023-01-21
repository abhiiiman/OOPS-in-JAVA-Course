// 8.11


class Time2 {
    private int hour;
    private int minute;
    private int second;

    public Time2() {
        this(0, 0, 0);
    }

    public Time2(int h, int m, int s) {
        setTime(h, m, s);
    }

    public boolean setHour(int h) {
        if (h >= 0 && h < 24) {
            hour = h;
            return true;
        } else {
            return false;
        }
    }

    public boolean setMinute(int m) {
        if (m >= 0 && m < 60) {
            minute = m;
            return true;
        } else {
            return false;
        }
    }

    public boolean setSecond(int s) {
        if (s >= 0 && s < 60) {
            second = s;
            return true;
        } else {
            return false;
        }
    }

    public boolean setTime(int h, int m, int s) {
        if (setHour(h) && setMinute(m) && setSecond(s)) {
            return true;
        } else {
            return false;
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void incrementHour() {
        if (++hour == 24) {
            hour = 0;
        }
    }

    public void incrementMinute() {
        if (++minute == 60) {
            minute = 0;
            incrementHour();
        }
    }

    public void incrementSecond() {
        if (++second == 60) {
            second = 0;
            incrementMinute();
        }
    }
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public String toString() {
        return String.format("%d:%02d:%02d %s",
                ((hour == 0 || hour == 12) ? 12 : hour % 12),
                minute, second, (hour < 12 ? "AM" : "PM"));
    }
}

class Date {
    private int month;
    private int day;
    private int year;

    private static final int[] daysPerMonth = 
    { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public Date() {
        this(1, 1, 1800);
    }

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
            if (month == 2 && day == 28 && isLeapYear()) {
                day++;
            } else if (month == 12 && day == 31) {
                day = 1;
                month = 1;
                year++;
            } else if (day == daysPerMonth[month]){
                day = 1;
                month++;
            }
        }
    }
    
    public boolean isLeapYear() {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }
}

public class DateAndTime {
    private Date date;
    private Time2 time;

    public DateAndTime() {
        this(new Date(), new Time2());
    }

    public DateAndTime(Date date, Time2 time) {
        this.date = date;
        this.time = time;
    }

    public void incrementHour() {
        time.incrementHour();
        if (time.getHour() == 0) {
            date.nextDay();
        }
    }

    public void incrementMinute() {
        time.incrementMinute();
        if (time.getMinute() == 0 && time.getHour() == 0) {
            date.nextDay();
        }
    }

    public void incrementSecond() {
        time.incrementSecond();
        if (time.getSecond() == 0 && time.getMinute() == 0 && time.getHour() == 0) {
            date.nextDay();
        }
    }

    public String toUniversalString() {
        return date.toString() + " " + time.toUniversalString();
    }

    public String toString() {
        return date.toString() + " " + time.toString();
    }

    public static void main(String[] args) {
        DateAndTime dateAndTime = new DateAndTime();
        System.out.println(dateAndTime.toUniversalString());
        System.out.println(dateAndTime.toString());
    
        dateAndTime.incrementSecond();
        System.out.println(dateAndTime.toUniversalString());
        System.out.println(dateAndTime.toString());
    
        dateAndTime.incrementMinute();
        System.out.println(dateAndTime.toUniversalString());
        System.out.println(dateAndTime.toString());
    
        dateAndTime.incrementHour();
        System.out.println(dateAndTime.toUniversalString());
        System.out.println(dateAndTime.toString());
    }    
}