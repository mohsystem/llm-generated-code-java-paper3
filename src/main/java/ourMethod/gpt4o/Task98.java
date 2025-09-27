package ourMethod.gpt4o;
import java.util.Scanner;

public class Task98 {
    public static Integer convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] testInputs = {"123", "abc", "456", "78.9", ""};
        for (String input : testInputs) {
            Integer result = convertToInteger(input);
            if (result != null) {
                System.out.println("Converted to integer: " + result);
            } else {
                System.out.println("Conversion failed for input: " + input);
            }
        }
        scanner.close();
    }
}