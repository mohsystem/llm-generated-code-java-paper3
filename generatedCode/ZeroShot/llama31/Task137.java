package ZeroShot.llama31;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task137 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product ID: ");
        String input = scanner.nextLine();

        // Input validation
        if (isValidInput(input)) {
            System.out.println("Product ID: " + input);
            // Simulate querying the product table
            System.out.println("Product Details: Product ID " + input + " found.");
        } else {
            System.out.println("Invalid input. Please enter a valid product ID.");
        }

        // Test cases
        testCases();
    }

    public static boolean isValidInput(String input) {
        // Allowlist validation for product ID (e.g., numeric only)
        return input.matches("\\d+");
    }

    public static void testCases() {
        System.out.println("Test Case 1: Valid input");
        System.out.println(isValidInput("12345") ? "Valid" : "Invalid");

        System.out.println("Test Case 2: Invalid input");
        System.out.println(isValidInput("abcde") ? "Valid" : "Invalid");

        System.out.println("Test Case 3: Empty input");
        System.out.println(isValidInput("") ? "Valid" : "Invalid");

        System.out.println("Test Case 4: Special characters");
        System.out.println(isValidInput("12345") ? "Valid" : "Invalid");

        System.out.println("Test Case 5: Negative number");
        System.out.println(isValidInput("-12345") ? "Valid" : "Invalid");
    }
}