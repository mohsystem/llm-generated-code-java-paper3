package Vanilla.llama31;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task55 {
    public static boolean validateEmail(String email) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(email);
        return matcher.find();
    }

    public static void main(String[] args) {
        String[] testCases = {"john.doe@example.com", "john.doe@example", "john doe@example.com", "john.doe@.com", "john.doe@example.com.au"};
        for (String testCase : testCases) {
            System.out.println(testCase + ": " + validateEmail(testCase));
        }
    }
}