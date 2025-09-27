package CoT.gpt4o;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task55 {
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) return false;
        
        // Regular expression to validate email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidEmail("test@example.com")); // true
        System.out.println(isValidEmail("user@domain.co.in")); // true
        System.out.println(isValidEmail("user.name@domain.com")); // true
        System.out.println(isValidEmail("user#domain.com")); // false
        System.out.println(isValidEmail("user@domaincom")); // false
    }
}