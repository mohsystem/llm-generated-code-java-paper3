package CoT.gpt4o;
import java.util.regex.*;

public class Task109 {
    
    public static boolean validateInput(String input, String pattern) {
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(validateInput("hello123", "\\w+")); // true
        System.out.println(validateInput("12345", "\\d+")); // true
        System.out.println(validateInput("hello@", "\\w+")); // false
        System.out.println(validateInput("email@example.com", "^[\\w._%+-]+@[\\w.-]+\\.\\w{2,6}$")); // true
        System.out.println(validateInput("123abc", "\\d+")); // false
    }
}