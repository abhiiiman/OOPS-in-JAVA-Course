// 8.12

class Enhanced_Rectangle {
    private double x1, y1, x2, y2, x3, y3, x4, y4;

    public Enhanced_Rectangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        setCoordinates(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public void setCoordinates(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        if (x1 < 0 || x2 < 0 || x3 < 0 || x4 < 0 || y1 < 0 || y2 < 0 || y3 < 0 || y4 < 0) {
            throw new IllegalArgumentException("All coordinates must be in the first quadrant");
        }

        if (x1 > 20 || x2 > 20 || x3 > 20 || x4 > 20 || y1 > 20 || y2 > 20 || y3 > 20 || y4 > 20) {
            throw new IllegalArgumentException("No single x- or y-coordinate can be larger than 20");
        }

        if ((x1 == x2 && y1 == y2) || (x1 == x3 && y1 == y3) || (x1 == x4 && y1 == y4) || (x2 == x3 && y2 == y3) || (x2 == x4 && y2 == y4) || (x3 == x4 && y3 == y4)) {
            throw new IllegalArgumentException("The supplied coordinates do not form a Rectangle");
        }

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
    }

    public double length() {
        double length1 = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double length2 = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
        return Math.max(length1, length2);
    }

    public double width() {
        double width1 = Math.sqrt((x1 - x4) * (x1 - x4) + (y1 - y4) * (y1 - y4));
        double width2 = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
        return Math.min(width1, width2);
    }

    public double perimeter() {
        double length = length();
        double width = width();
        return 2 * (length + width);
    }

    public double area() {
        double length = length();
        double width = width();
        return length * width;
    }

    public boolean isSquare() {
        double length = length();
        double width = width();
        return length == width;
    }

    public static void main(String[] args) {
        Enhanced_Rectangle rect = new Enhanced_Rectangle(1,1,1,10,10,10,10,1);
        System.out.println("Length: " + rect.length());
        System.out.println("Width: " + rect.width());
        System.out.println("Perimeter: " + rect.perimeter());
        System.out.println("Area: " + rect.area());
        System.out.println("Is square: " + rect.isSquare());
    }

}
