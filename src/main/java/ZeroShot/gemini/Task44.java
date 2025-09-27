package ZeroShot.gemini;
import java.util.Scanner;

public class Task44 {

    public static String processInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Invalid input: Input cannot be empty or contain only whitespace.";
        }

        // Perform operations on the validated input (example: reversing the string)
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");

        String input = scanner.nextLine();
        String result = processInput(input);
        System.out.println("Processed string: " + result);

          // Test cases
        System.out.println(processInput("hello"));
        System.out.println(processInput("world"));
        System.out.println(processInput(""));
        System.out.println(processInput("   "));
        System.out.println(processInput("12345"));
    }
}