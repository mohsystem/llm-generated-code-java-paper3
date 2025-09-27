package ZeroShot.llama31;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task55 {
    public static boolean isValidEmail(String email) {
        String pattern = "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testCases = {"test@example.com", "invalid.email", "test@example.co.uk", "test@.com", "test@example"};
        for (String testCase : testCases) {
            System.out.println(testCase + " is valid: " + isValidEmail(testCase));
        }
    }
}