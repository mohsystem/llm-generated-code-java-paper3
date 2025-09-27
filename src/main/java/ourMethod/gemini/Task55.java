package ourMethod.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task55 {

    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        // Regular expression for email validation
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testCases = {
                "test@example.com",
                "invalid-email",
                "another.test@sub.example.co.uk",
                "test@.com",
                "123@example"
        };

        for (String testCase : testCases) {
            System.out.println(testCase + ": " + isValidEmail(testCase));
        }
    }
}