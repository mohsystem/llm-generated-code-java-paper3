package CoT.gemini;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task44 {

    public static int performOperation(int num1, int num2, String operation) {
        switch (operation) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            scanner.nextLine(); // Consume newline

            System.out.print("Enter operation (+, -, *, /): ");
            String operation = scanner.nextLine().trim();


            int result = performOperation(num1, num2, operation);
            System.out.println("Result: " + result);


        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter numbers only.");
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
         // Test cases
        System.out.println(performOperation(5, 2, "+")); // Output: 7
        System.out.println(performOperation(10, 3, "-")); // Output: 7
        System.out.println(performOperation(4, 6, "*")); // Output: 24
        System.out.println(performOperation(12, 4, "/")); // Output: 3
        System.out.println(performOperation(8, 2, "/")); // Output: 4

    }
}