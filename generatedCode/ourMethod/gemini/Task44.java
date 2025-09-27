package ourMethod.gemini;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task44 {

    public static double performOperation(double num1, double num2, String operator) {
        switch (operator) {
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
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            System.out.print("Enter operator (+, -, *, /): ");
            String operator = scanner.next();

            if (!operator.matches("[+\\-*/]")) {
                throw new IllegalArgumentException("Invalid operator.");
            }


            double result = performOperation(num1, num2, operator);
            System.out.println("Result: " + result);

             // Test cases
            System.out.println(performOperation(5, 2, "+")); // Expected: 7.0
            System.out.println(performOperation(10, 3, "-")); // Expected: 7.0
            System.out.println(performOperation(4, 6, "*")); // Expected: 24.0
            System.out.println(performOperation(8, 4, "/")); // Expected: 2.0
            System.out.println(performOperation(12.5, 2.5, "/")); // Expected: 5.0


        } catch (InputMismatchException e) {
            System.err.println("Invalid input: Please enter numbers.");
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}