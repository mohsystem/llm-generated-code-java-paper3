package ourMethodv2.gpt4o;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task45 {

    public static int performOperation(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero.");
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] testCases = {1, 2, 3, 4, 5};
        
        for (int i : testCases) {
            try {
                System.out.print("Enter integer a: ");
                int a = scanner.nextInt();
                System.out.print("Enter integer b: ");
                int b = scanner.nextInt();
                int result = performOperation(a, b);
                System.out.println("Result of operation: " + result);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers only.");
                scanner.next(); // Clear invalid input
            }
        }
        scanner.close();
    }
}