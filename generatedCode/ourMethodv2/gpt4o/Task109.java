package ourMethodv2.gpt4o;
import java.util.regex.Pattern;

public class Task109 {

    public static boolean validateInput(String input) {
        if (input == null) return false;
        String regex = "^[a-zA-Z0-9]*$"; // Only allows alphanumeric characters
        return Pattern.matches(regex, input);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(validateInput("Hello123")); // true
        System.out.println(validateInput("Hello 123")); // false
        System.out.println(validateInput("Hello@123")); // false
        System.out.println(validateInput("123456")); // true
        System.out.println(validateInput("abcdefg")); // true
    }
}