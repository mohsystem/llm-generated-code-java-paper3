package Vanilla.openai;
import java.util.regex.*;

public class Task109 {
    public static boolean validateInput(String input, String pattern) {
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(validateInput("abc123", "\\w+")); // true
        System.out.println(validateInput("123-456", "\\d{3}-\\d{3}")); // true
        System.out.println(validateInput("Hello, World!", "[A-Za-z, ]+")); // true
        System.out.println(validateInput("1234", "\\d{5}")); // false
        System.out.println(validateInput("email@example.com", "[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}")); // true
    }
}