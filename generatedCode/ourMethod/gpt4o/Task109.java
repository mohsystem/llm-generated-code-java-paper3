package ourMethod.openai;
import java.util.regex.*;

public class Task109 {

    public static boolean validateInput(String input, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(validateInput("test@example.com", "^[A-Za-z0-9+_.-]+@(.+)$")); // true
        System.out.println(validateInput("123-456-7890", "^[0-9]{3}-[0-9]{3}-[0-9]{4}$")); // true
        System.out.println(validateInput("invalid-email", "^[A-Za-z0-9+_.-]+@(.+)$")); // false
        System.out.println(validateInput("123456", "^[0-9]{3}-[0-9]{3}-[0-9]{4}$")); // false
        System.out.println(validateInput("TestUser123", "^[A-Za-z0-9]+$")); // true
    }
}