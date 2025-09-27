package ZeroShot.llama31;
import java.util.Scanner;

public class Task41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] testCases = {"Hello", "World", "This is a test string", "Buffer overflow test", "Very long string to test buffer overflow"};
        
        for (String testCase : testCases) {
            System.out.print("Enter a string (or press Enter to use default '" + testCase + "'): ");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                input = testCase;
            }
            processString(input);
        }
    }

    public static void processString(String input) {
        System.out.println("Processed string: " + input);
    }
}