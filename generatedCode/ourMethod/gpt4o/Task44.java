package ourMethod.openai;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task44 {
    public static String processInput(String input) {
        // Ensure input is alphanumeric to avoid injection attacks
        if (input == null || !Pattern.matches("[a-zA-Z0-9 ]+", input)) {
            throw new IllegalArgumentException("Invalid input");
        }
        // Perform operations
        return input.trim().toUpperCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] testInputs = {"Hello World", "Valid123", "Test Input", "Security", "JavaCode"};
        for (String input : testInputs) {
            try {
                System.out.println(processInput(input));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}