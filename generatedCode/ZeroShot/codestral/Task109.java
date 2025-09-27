package ZeroShot.codestral;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task109 {
    public static boolean validateInput(String input) {
        // A simple regex that matches any non-empty string
        String regex = "^(.*[^\\s])";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(validateInput("Hello, World!")); // Expected: true
        System.out.println(validateInput(" ")); // Expected: false
        System.out.println(validateInput("")); // Expected: false
        System.out.println(validateInput("12345")); // Expected: true
        System.out.println(validateInput("Test@123")); // Expected: true
    }
}