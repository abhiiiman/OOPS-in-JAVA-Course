// 8.9

enum TrafficLight {
    RED(30), GREEN(45), YELLOW(5);

    private int duration;

    private TrafficLight(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static void main(String[] args) {
        for (TrafficLight light : TrafficLight.values()) {
            System.out.printf("%s: %d seconds%n", light, light.getDuration());
        }
    }
}
