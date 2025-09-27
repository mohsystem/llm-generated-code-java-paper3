package Vanilla.gemini;
import java.util.Scanner;
import java.util.InputMismatchException;

class Task44 {
    public static int validatedIntegerInput(Scanner scanner) {
        int input;
        while (true) {
            try {
                input = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear the invalid input
            }
        }
        return input;
    }

    public static String validatedStringInput(Scanner scanner) {
        String input;
        while (true) {
            input = scanner.next();
            if (input.matches("[a-zA-Z0-9]+")) { // Alphanumeric characters only
                break;
            } else {
                System.out.println("Invalid input. Please enter alphanumeric characters only.");
            }
        }
        return input;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer:");
        int num1 = validatedIntegerInput(scanner);

        System.out.println("Enter another integer:");
        int num2 = validatedIntegerInput(scanner);

        System.out.println("Enter a string (alphanumeric characters only):");
        String str = validatedStringInput(scanner);


        System.out.println("Sum: " + (num1 + num2));
        System.out.println("String: " + str);



        // Test cases
        test(10, 20, "hello");
        test(5, 15, "world");
        test(-5, 5, "test1");
        test(100, 200, "test2");
        test(0, 0, "test3");



        scanner.close();
    }


    public static void test(int num1, int num2, String str) {
        System.out.println("Test case: num1=" + num1 + ", num2=" + num2 + ", str=" + str);
        System.out.println("Expected Sum: " + (num1+num2));
        System.out.println("String: " + str);
    }
}