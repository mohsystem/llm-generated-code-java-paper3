package Vanilla.codestral;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task109 {
    public static boolean validateInput(String input) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]{6,}"); // At least 6 alphanumeric characters
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testCases = {"Abc123", "abc", "abc123def", "abc!@#", "123456"};
        for (String testCase : testCases) {
            System.out.println(testCase + ": " + validateInput(testCase));
        }
    }
}