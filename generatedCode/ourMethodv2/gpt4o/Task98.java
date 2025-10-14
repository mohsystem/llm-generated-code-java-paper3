package ourMethodv2.gpt4o;
import java.util.Scanner;

public class Task98 {
    public static Integer safeConvertToInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] testInputs = {"123", "abc", "45", "12.34", "  67  "};
        
        for (String input : testInputs) {
            Integer result = safeConvertToInt(input);
            if (result != null) {
                System.out.println("Converted integer: " + result);
            } else {
                System.out.println("Invalid integer input: " + input);
            }
        }
    }
}