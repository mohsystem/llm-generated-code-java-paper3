package ourMethod.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task109 {

    public static boolean isValidInput(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidInput("abc123", "^[a-zA-Z0-9]+$")); // True - alphanumeric
        System.out.println(isValidInput("123.45", "^\\d+\\.\\d+$")); // True - floating-point number
        System.out.println(isValidInput("john.doe@example.com", "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")); // True - email
        System.out.println(isValidInput("123-456-7890", "^\\d{3}-\\d{3}-\\d{4}$")); // True - phone number
        System.out.println(isValidInput("abc$", "^[a-zA-Z]+$")); // False - contains special character
    }
}