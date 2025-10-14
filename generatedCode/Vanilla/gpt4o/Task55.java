package Vanilla.openai;
import java.util.regex.*;

public class Task55 {
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidEmail("test@example.com")); // true
        System.out.println(isValidEmail("user@domain.co.in")); // true
        System.out.println(isValidEmail("username@.com")); // false
        System.out.println(isValidEmail("username@domaincom")); // false
        System.out.println(isValidEmail("user.name@domain.com")); // true
    }
}