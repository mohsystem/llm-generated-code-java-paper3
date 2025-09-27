package Vanilla.llama31;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task44 {
    public static boolean isValidEmail(String email) {
        String emailPattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public static void main(String[] args) {
        String[] testCases = {"test@example.com", "invalid-email", "test@example", "test@.com", "test@example.com.au"};
        for (String testCase : testCases) {
            if (isValidEmail(testCase)) {
                System.out.println(testCase + " is a valid email.");
            } else {
                System.out.println(testCase + " is not a valid email.");
            }
        }
    }
}