package ZeroShot.gpt4o;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task45 {
    public static int performOperation(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.err.println("Error: Division by zero is not allowed.");
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 0, b = 0;
        try {
            System.out.println("Enter two integers: ");
            a = scanner.nextInt();
            b = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input. Please enter integers.");
            return;
        } finally {
            scanner.close();
        }

        System.out.println("Result of operation: " + performOperation(a, b));
        
        // Test cases
        System.out.println("Test 1: " + performOperation(10, 2));
        System.out.println("Test 2: " + performOperation(10, 0));
        System.out.println("Test 3: " + performOperation(-10, 2));
        System.out.println("Test 4: " + performOperation(10, -2));
        System.out.println("Test 5: " + performOperation(0, 1));
    }
}