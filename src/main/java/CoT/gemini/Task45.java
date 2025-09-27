package CoT.gemini;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task45 {

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
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            System.out.print("Enter operation (+, -, *, /): ");
            String operation = scanner.next();

            int result = performOperation(num1, num2, operation);
            System.out.println("Result: " + result);

             // Test cases
            System.out.println(performOperation(5, 2, "+")); // 7
            System.out.println(performOperation(10, 3, "-")); // 7
            System.out.println(performOperation(4, 6, "*")); // 24
            System.out.println(performOperation(8, 2, "/")); // 4
            System.out.println(performOperation(5, 0, "/")); // Exception


        } catch (InputMismatchException e) {
            System.err.println("Invalid input: Please enter numbers.");
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}