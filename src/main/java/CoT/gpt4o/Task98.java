package CoT.gpt4o;
import java.util.Scanner;

public class Task98 {
    public static Integer convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] testInputs = {"123", "abc", "456", "78.9", "1000"};
        
        for (String input : testInputs) {
            Integer result = convertToInt(input);
            if (result != null) {
                System.out.println("Converted: " + result);
            } else {
                System.out.println("Conversion failed for input: " + input);
            }
        }
        scanner.close();
    }
}