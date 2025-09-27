package CoT.llama31;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task109 {
    public static boolean validateInput(String input) {
        String pattern = "^[a-zA-Z0-9_.]+$";
        return Pattern.matches(pattern, input);
    }

    public static void main(String[] args) {
        String[] testCases = {"abc123", "abc.123", "abc_123", "abc@123", "!abc123"};
        for (String testCase : testCases) {
            System.out.println("Input: " + testCase + ", Valid: " + validateInput(testCase));
        }
    }
}