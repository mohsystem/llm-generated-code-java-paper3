package ZeroShot.openai;
import java.util.regex.Pattern;

public class Task109 {
    public static boolean validateInput(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input).matches();
    }

    public static void main(String[] args) {
        System.out.println(validateInput("abc123", "^[a-zA-Z0-9]+$")); // true
        System.out.println(validateInput("abc!123", "^[a-zA-Z0-9]+$")); // false
        System.out.println(validateInput("hello@example.com", "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")); // true
        System.out.println(validateInput("helloexample.com", "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")); // false
        System.out.println(validateInput("12345", "^\\d+$")); // true
    }
}