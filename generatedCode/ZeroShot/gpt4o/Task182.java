package ZeroShot.openai;
import java.util.regex.*;

public class Task182 {
    public static String cleanNumber(String input) {
        // Remove all non-digit characters
        String cleaned = input.replaceAll("[^0-9]", "");

        // Remove leading '1' if present
        if (cleaned.length() == 11 && cleaned.startsWith("1")) {
            cleaned = cleaned.substring(1);
        }

        // Validate the cleaned number
        if (!cleaned.matches("[2-9][0-9]{2}[2-9][0-9]{6}")) {
            throw new IllegalArgumentException("Invalid NANP phone number");
        }

        return cleaned;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(cleanNumber("+1 (613)-995-0253")); // Output: 6139950253
        System.out.println(cleanNumber("613-995-0253"));       // Output: 6139950253
        System.out.println(cleanNumber("1 613 995 0253"));     // Output: 6139950253
        System.out.println(cleanNumber("613.995.0253"));       // Output: 6139950253
        System.out.println(cleanNumber("1-800-555-0123"));     // Output: 8005550123
    }
}