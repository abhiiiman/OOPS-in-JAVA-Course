// 8.5

public class Time2 {
    private int totalSeconds;

    public Time2() {
        this(0, 0, 0);
    }

    public Time2(int h, int m, int s) {
        setTime(h, m, s);
    }

    public void setTime(int h, int m, int s) {
        totalSeconds = h * 3600 + m * 60 + s;
    }

    public int getHour() {
        return totalSeconds / 3600;
    }

    public int getMinute() {
        return (totalSeconds % 3600) / 60;
    }

    public int getSecond() {
        return totalSeconds % 60;
    }

    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

    public String toString() {
        return String.format("%d:%02d:%02d %s",
                (getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12,
                getMinute(), getSecond(), (getHour() < 12) ? "AM" : "PM");
    }

    public static void main(String[] args) {
        Time2 time = new Time2();
        System.out.println("The initial universal time is: " + time.toUniversalString());
        System.out.println("The initial standard time is: " + time.toString());
        System.out.println();

        time.setTime(13, 27, 6);
        System.out.println("Universal time after setTime is: " + time.toUniversalString());
        System.out.println("Standard time after setTime is: " + time.toString());
    }
}