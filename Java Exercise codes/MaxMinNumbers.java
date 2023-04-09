public class MaxMinNumbers {
    public static void main(String[] args) {
        int n = args.length;
        int[] numbers = new int[n];
        
        // Convert command line arguments to integers
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(args[i]);
        }
        
        // Find maximum and minimum numbers
        int max = numbers[0];
        int min = numbers[0];
        for (int i = 1; i < n; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        
        // Print results
        System.out.println("Maximum number is: " + max);
        System.out.println("Minimum number is: " + min);
    }
}
