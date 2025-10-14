package ourMethodv2.gpt4o;
import java.util.Scanner;

public class Task38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String userInput = scanner.nextLine();

        System.out.println("You entered: " + userInput);

        // Test cases
        System.out.println("Test case 1: " + processInput("Hello, World!"));
        System.out.println("Test case 2: " + processInput("123456"));
        System.out.println("Test case 3: " + processInput(""));
        System.out.println("Test case 4: " + processInput("Special characters! @#$%^&*()"));
        System.out.println("Test case 5: " + processInput("Another test case"));
    }

    public static String processInput(String input) {
        // Basic input validation
        if (input == null || input.length() > 1000) {
            return "Invalid input.";
        }
        return "You entered: " + input;
    }
}