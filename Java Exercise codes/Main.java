class Arithmetic {
    public int add(int num1, int num2) {
        return num1 + num2;
    }
}

class Adder extends Arithmetic {
    public int add(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }
}

public class Main {
    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic();
        Adder adder = new Adder();

        // Calling the add method of Arithmetic
        int sum1 = arithmetic.add(10, 20);
        System.out.println("Sum of 10 and 20 is " + sum1);

        // Calling the add method of Adder
        int sum2 = adder.add(10, 20, 30);
        System.out.println("Sum of 10, 20 and 30 is " + sum2);
    }
}
