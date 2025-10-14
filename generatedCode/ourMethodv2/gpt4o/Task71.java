package ourMethodv2.gpt4o;
import java.util.Scanner;

public class Task71 {
    public static void main(String[] args) {
        testCases();
    }

    public static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, cannot convert to integer: " + input);
            return 0;
        }
    }

    public static void testCases() {
        String[] testInputs = {"123", "abc", "456", "-789", "1.23"};
        for (String input : testInputs) {
            System.out.println("Input: " + input + " Output: " + convertStringToInt(input));
        }
    }
}