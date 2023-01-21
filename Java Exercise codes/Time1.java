// 8.6

class Time1 {
    private int totalSeconds;

    public Time1() {
        this(0, 0, 0);
    }

    public Time1(int h, int m, int s) {
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

    public void tick() {
        totalSeconds++;
        if (totalSeconds >= 86400) { // 86400 seconds in a day
            totalSeconds = 0;
        }
    }

    public void incrementMinute() {
        totalSeconds += 60;
        if (totalSeconds >= 86400) {
            totalSeconds = 0;
        }
    }

    public void incrementHour() {
        totalSeconds += 3600;
        if (totalSeconds >= 86400) {
            totalSeconds = 0;
        }
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
        Time1 time = new Time1(11, 59, 59);
        System.out.println("Initial time: " + time.toUniversalString());
        time.tick();
        System.out.println("Time after tick: " + time.toUniversalString());
    }
}
