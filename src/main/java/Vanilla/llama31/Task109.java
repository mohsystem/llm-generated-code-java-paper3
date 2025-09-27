package Vanilla.llama31;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task109 {
    public static boolean validateInput(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testCases = {
            "password123!", // Valid password (at least 8 chars, capital, number, symbol)
            "invalid",     // Invalid password
            "test@example.com", // Valid email
            "invalid_email",    // Invalid email
            "JohnDoe"          // Valid name (only alphabets)
        };

        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*\\W).{8,}$";
        String emailRegex = "^[\\w+\\.\\-]+@[\\w+\\.\\-]+\\.[a-zA-Z]{2,}$";
        String nameRegex = "^[A-Za-z]+$";

        for (String testCase : testCases) {
            System.out.println("Password Validation: " + testCase + " - " + validateInput(testCase, passwordRegex));
            System.out.println("Email Validation: " + testCase + " - " + validateInput(testCase, emailRegex));
            System.out.println("Name Validation: " + testCase + " - " + validateInput(testCase, nameRegex));
            System.out.println();
        }
    }
}