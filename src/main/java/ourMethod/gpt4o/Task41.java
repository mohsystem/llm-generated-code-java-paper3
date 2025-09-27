package ourMethod.gpt4o;
import java.util.Scanner;

public class Task41 {
    public static String processInput(String input) {
        return input.trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test cases
        String[] testCases = {
            "  Hello World  ",
            "Java Programming",
            "   Secure Code   ",
            "Input   ",
            "   Test Case 5   "
        };

        for (String testCase : testCases) {
            System.out.println("Processed: '" + processInput(testCase) + "'");
        }

        scanner.close();
    }
}