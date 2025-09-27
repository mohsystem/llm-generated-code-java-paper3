package CoT.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task109 {

    public static boolean isValidInput(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidInput("12345", "^\\d{5}$")); // True - 5 digits
        System.out.println(isValidInput("abcde", "^[a-zA-Z]{5}$")); // True - 5 letters
        System.out.println(isValidInput("123456", "^\\d{5}$")); // False - 6 digits
        System.out.println(isValidInput("abcd", "^[a-zA-Z]{5}$")); // False - 4 letters
        System.out.println(isValidInput("123ab", "^\\d{5}$")); // False - mixed input
    }
}