// 8.8

public class Time3 {
    private int hour;
    private int minute;
    private int second;

    public Time3() {
        this(0, 0, 0);
    }

    public Time3(int h, int m, int s) {
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

    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public String toString() {
        return String.format("%d:%02d:%02d %s",
                ((hour == 0 || hour == 12) ? 12 : hour % 12),
                minute, second, (hour < 12) ? "AM" : "PM");
    }

    public static void main(String[] args) {
        Time3 time = new Time3();
        if (!time.setHour(25)) {
            System.out.println("Invalid hour value");
        }
        if (!time.setMinute(60)) {
            System.out.println("Invalid minute value");
        }
        if (!time.setSecond(61));
    }
}
