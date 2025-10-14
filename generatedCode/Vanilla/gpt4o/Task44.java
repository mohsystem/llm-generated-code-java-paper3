package Vanilla.openai;
import java.util.Scanner;

public class Task44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Test cases for Java
        System.out.println(performOperation(5));  // Example test case
        System.out.println(performOperation(-1));
        System.out.println(performOperation(10));
        System.out.println(performOperation(0));
        System.out.println(performOperation(100));

        scanner.close();
    }

    public static String performOperation(int input) {
        if (input < 0) {
            return "Invalid input";
        }
        return "Operation result: " + (input * 2);
    }
}