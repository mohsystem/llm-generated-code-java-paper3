package ourMethod.gemini;
import java.util.Scanner;

public class Task140 {

    public static double calculate(double num1, double num2, String operator) {
        double result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        String operator;

        try {
            System.out.print("Enter first number: ");
            num1 = scanner.nextDouble();

            System.out.print("Enter operator (+, -, *, /): ");
            operator = scanner.next();

            System.out.print("Enter second number: ");
            num2 = scanner.nextDouble();


            result = calculate(num1, num2, operator);
            System.out.println("Result: " + result);


            System.out.println("Test cases:");
            System.out.println(calculate(5, 2, "+")); // Expected: 7.0
            System.out.println(calculate(10, 4, "-")); // Expected: 6.0
            System.out.println(calculate(3, 6, "*")); // Expected: 18.0
            System.out.println(calculate(8, 2, "/")); // Expected: 4.0
            System.out.println(calculate(20,4,"/")); //Expected: 5.0

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}