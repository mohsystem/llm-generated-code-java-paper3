package CoT.llama31;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task55 {
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public static void main(String[] args) {
        String[] testCases = {"ankitrai326@gmail.com", "my.ownsite@our-earth.org", "ankitrai326.com", "invalid-email", "test@example.co.uk"};
        for (String testCase : testCases) {
            if (isValidEmail(testCase)) {
                System.out.println(testCase + " is a valid email");
            } else {
                System.out.println(testCase + " is not a valid email");
            }
        }
    }
}