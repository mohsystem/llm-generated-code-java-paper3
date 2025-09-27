package Vanilla.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task109 {
    public static boolean isValidInput(String input) {
        // Example: Validate email format
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidInput("test@example.com")); // true
        System.out.println(isValidInput("invalid_email")); // false
        System.out.println(isValidInput("another.test@subdomain.example.com")); // true
        System.out.println(isValidInput("123@456.789")); // true
        System.out.println(isValidInput("test@@example.com")); // false
    }
}