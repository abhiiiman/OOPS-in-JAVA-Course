import java.util.Scanner;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int digitCount = 0;
        int otherCount = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                upperCaseCount++;
            } else if (ch >= 'a' && ch <= 'z') {
                lowerCaseCount++;
            } else if (ch >= '0' && ch <= '9') {
                digitCount++;
            } else {
                otherCount++;
            }
        }
        
        System.out.println("Uppercase letters: " + upperCaseCount);
        System.out.println("Lowercase letters: " + lowerCaseCount);
        System.out.println("Digits: " + digitCount);
        System.out.println("Other characters: " + otherCount);
    }
}
