// 8.10

public class Complex {
    private double real;
    private double imaginary;

    public Complex() {
        this(0, 0);
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex add(Complex other) {
        return new Complex(real + other.real, imaginary + other.imaginary);
    }

    public Complex subtract(Complex other) {
        return new Complex(real - other.real, imaginary - other.imaginary);
    }

    public void print() {
        System.out.printf("(%.2f, %.2f)", real, imaginary);
    }

    public static void main(String[] args) {
        Complex c1 = new Complex(3, 2);
        Complex c2 = new Complex(1, 7);
        Complex c3 = c1.add(c2);
        Complex c4 = c1.subtract(c2);

        System.out.print("c1 = ");
        c1.print();
        System.out.print("\nc2 = ");
        c2.print();
        System.out.print("\nc1 + c2 = ");
        c3.print();
        System.out.print("\nc1 - c2 = ");
        c4.print();
    }
}