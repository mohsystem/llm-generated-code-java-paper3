package ourMethodv2.gpt4o;
import java.util.Scanner;

public class Task44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test cases
        processInput("123");
        processInput("456");
        processInput("789");
        processInput("101");
        processInput("112");

        // User input
        System.out.println("Enter a number:");
        String input = scanner.nextLine();
        processInput(input);

        scanner.close();
    }

    public static void processInput(String input) {
        if (input != null && input.matches("\\d+")) {
            int number = Integer.parseInt(input);
            int result = number * 2;
            System.out.println("Processed result: " + result);
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}