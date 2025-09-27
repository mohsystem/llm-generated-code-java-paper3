package ourMethod.gemini;
import java.util.Scanner;

public class Task98 {

    public static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // Or throw an exception, depending on desired behavior
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] testCases = {"123", "456.78", "abc", "-900", "10000000000"};

        for (String testCase : testCases) {
            int result = convertToInt(testCase);
            System.out.println("Input: " + testCase + ", Output: " + result);
        }
         scanner.close();
    }
}