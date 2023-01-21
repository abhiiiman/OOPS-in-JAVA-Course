// 8.15

public class HugeInteger {
    private int[] digits;

    public HugeInteger() {
        digits = new int[40];
    }

    public void input(String number) {
        if (number.length() > 40) {
            System.out.println("Error: Number is too large to fit in the array.");
        } else {
            for (int i = 0; i < number.length(); i++) {
                digits[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
            }
        }
    }

    public void output() {
        for (int digit : digits) {
            System.out.print(digit);
        }
        System.out.println();
    }

    public void add(HugeInteger other) {
        for (int i = 0; i < digits.length; i++) {
            digits[i] += other.digits[i];
        }
    }

    public void subtract(HugeInteger other) {
        for (int i = 0; i < digits.length; i++) {
            digits[i] -= other.digits[i];
        }
    }

    public boolean isEqualTo(HugeInteger other) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != other.digits[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isNotEqualTo(HugeInteger other) {
        return !isEqualTo(other);
    }

    public boolean isLessThan(HugeInteger other) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] < other.digits[i]) {
                return true;
            } else if (digits[i] > other.digits[i]) {
                return false;
            }
        }
        return false;
    }
    
    public boolean isGreaterThan(HugeInteger other) {
        for (int i = 0; i > digits.length; i++) {
            if (digits[i] > other.digits[i]) {
                return true;
            } else if (digits[i] < other.digits[i]) {
                return false;
            }
        }
        return false;
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger other) {
        return (isGreaterThan(other) || isEqualTo(other));
    }
    
    public boolean isLessThanOrEqualTo(HugeInteger other) {
        return (isLessThan(other) || isEqualTo(other));
    }
    
    public static void main(String[] args) {
        HugeInteger num1 = new HugeInteger();
        HugeInteger num2 = new HugeInteger();

        num1.input("123456789012345678901234567890");
        num2.input("987654321098765432109876543210");

        System.out.print("Number 1: ");
        num1.output();
        System.out.print("Number 2: ");
        num2.output();

        num1.add(num2);
        System.out.print("Number 1 + Number 2: ");
        num1.output();

        num1.subtract(num2);
        System.out.print("Number 1 - Number 2: ");
        num1.output();

        if (num1.isEqualTo(num2)) {
            System.out.println("Number 1 is equal to Number 2.");
        } else {
            System.out.println("Number 1 is not equal to Number 2.");
        }

        if (num1.isGreaterThan(num2)) {
            System.out.println("Number 1 is greater than Number 2.");
        } else {
            System.out.println("Number 1 is not greater than Number 2.");
        }

        if (num1.isLessThan(num2)) {
            System.out.println("Number 1 is less than Number 2.");
        } else {
            System.out.println("Number 1 is not less than Number 2.");
        }

        if (num1.isGreaterThanOrEqualTo(num2)) {
            System.out.println("Number 1 is greater than or equal to Number 2.");
        } else {
            System.out.println("Number 1 is not greater than or equal to Number 2.");
        }

        if (num1.isLessThanOrEqualTo(num2)) {
            System.out.println("Number 1 is less than or equal to Number 2.");
        } else {
            System.out.println("Number 1 is not less than or equal to Number 2.");
        }
    }
}