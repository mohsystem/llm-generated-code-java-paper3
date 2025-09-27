package ourMethod.gpt4o;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task55 {
    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidEmail("test@example.com")); // true
        System.out.println(isValidEmail("invalid-email")); // false
        System.out.println(isValidEmail("user@.com")); // false
        System.out.println(isValidEmail("user@domain.co.uk")); // true
        System.out.println(isValidEmail("user@domain")); // false
    }
}