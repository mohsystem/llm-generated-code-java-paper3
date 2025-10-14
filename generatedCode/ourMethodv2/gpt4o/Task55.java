package ourMethodv2.gpt4o;
import java.util.regex.Pattern;

public class Task55 {
    // Function to validate email address
    public static boolean isValidEmail(String email) {
        // Regex to check valid email address
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.compile(regex).matcher(email).matches();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidEmail("example@example.com")); // true
        System.out.println(isValidEmail("user.name@domain.co.in")); // true
        System.out.println(isValidEmail("user#@domain.co")); // true
        System.out.println(isValidEmail("user@domaincom")); // false
        System.out.println(isValidEmail("user@.com")); // false
    }
}