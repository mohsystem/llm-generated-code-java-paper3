package ourMethod.gemini;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task45 {

    public static int performOperation(int choice, int num1, int num2) {
        int result = 0;
        switch (choice) {
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                result = num1 / num2;
                break;
            case 4:
                result = num1 * num2;
                break;
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            System.out.print("Enter choice (1:add, 2:subtract, 3:divide, 4:multiply): ");
            int choice = scanner.nextInt();

            int result = performOperation(choice, num1, num2);
            System.out.println("Result: " + result);


        } catch (InputMismatchException e) {
            System.err.println("Invalid input: Please enter integers only.");
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }

        // Test cases
        System.out.println(performOperation(1, 10, 5)); // 15
        System.out.println(performOperation(2, 10, 5)); // 5
        System.out.println(performOperation(4, 10, 5)); // 50

        try {
            System.out.println(performOperation(3, 10, 0));
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage()); // Cannot divide by zero
        }

        try {
            System.out.println(performOperation(5, 10, 5));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage()); // Invalid Choice
        }


    }
}