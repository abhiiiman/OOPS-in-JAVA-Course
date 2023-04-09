import java.util.*;

public class ParenthesisChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string of parentheses: ");
        String input = sc.nextLine();
        
        if (isBalanced(input)) {
            System.out.println("The input string is balanced.");
        } else {
            System.out.println("The input string is not balanced.");
        }
    }
    
    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}