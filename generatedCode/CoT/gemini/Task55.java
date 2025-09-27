package CoT.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task55 {

    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        // Regular expression pattern for email validation
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public static void main(String[] args) {
        String email1 = "test@example.com";
        String email2 = "invalid.email";
        String email3 = "another.test@subdomain.example.co.uk";
        String email4 = "12345@numbers.com";
        String email5 = "test+mailing@example.org";


        System.out.println(isValidEmail(email1)); // Output: true
        System.out.println(isValidEmail(email2)); // Output: false
        System.out.println(isValidEmail(email3)); // Output: true
        System.out.println(isValidEmail(email4)); // Output: true
        System.out.println(isValidEmail(email5)); // Output: true

    }
}