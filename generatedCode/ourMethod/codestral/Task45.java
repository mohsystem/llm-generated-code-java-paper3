package ourMethod.codestral;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter first number:");
            double num1 = scanner.nextDouble();

            System.out.println("Enter second number:");
            double num2 = scanner.nextDouble();

            System.out.println("Enter an operator (+, -, *, /):");
            char operator = scanner.next().charAt(0);

            double result;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator. Please use +, -, *, or /.");
            }

            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a number.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}