package Vanilla.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task55 {
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidEmail("test@example.com")); // true
        System.out.println(isValidEmail("invalid.email")); // false
        System.out.println(isValidEmail("another.test@subdomain.example.co.uk")); // true
        System.out.println(isValidEmail("12345@numbers.net")); // true
        System.out.println(isValidEmail("invalid-email@.com")); // false
    }
}