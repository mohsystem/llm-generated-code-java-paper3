package ourMethod.llama31;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task55 {
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testCases = {
            "ankitrai326@gmail.com",
            "my.ownsite@our-earth.org",
            "ankitrai326.com",
            "invalid@email",
            "another@valid.email"
        };

        for (String testCase : testCases) {
            System.out.println(testCase + " : " + (isValidEmail(testCase) ? "Valid" : "Invalid"));
        }
    }
}