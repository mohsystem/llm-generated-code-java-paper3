package ZeroShot.openai;
import java.util.regex.*;

public class Task55 {

    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidEmail("test@example.com")); // true
        System.out.println(isValidEmail("invalid-email"));    // false
        System.out.println(isValidEmail("another@test.co"));  // true
        System.out.println(isValidEmail("bad@domain"));       // false
        System.out.println(isValidEmail("good123@domain.org"));// true
    }
}