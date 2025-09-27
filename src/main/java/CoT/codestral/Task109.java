package CoT.codestral;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task109 {
    public static boolean validateInput(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] inputs = {"hello", "12345", "hello123", "", "hello@world"};
        String regex = "^[a-zA-Z0-9]+$"; // Alphanumeric characters only

        for (String input : inputs) {
            System.out.println(input + ": " + validateInput(input, regex));
        }
    }
}