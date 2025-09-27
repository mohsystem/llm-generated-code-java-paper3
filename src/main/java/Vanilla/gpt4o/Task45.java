package Vanilla.gpt4o;
import java.util.Scanner;

public class Task45 {
    public static int performOperation(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputs = {10, 20, -5, 15, 0};
        
        for (int input : inputs) {
            try {
                System.out.println("Result of operation with " + input + " and 5: " + performOperation(input, 5));
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}