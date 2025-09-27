package ZeroShot.claude;

import java.util.regex.Pattern;

public class Task109 {
    public static boolean validateInput(String input) {
        // Validate that input contains only letters, numbers and basic punctuation
        // Length between 5-50 chars
        String pattern = "^[a-zA-Z0-9\\\\s.,!?-]{5,50}$";
        return Pattern.matches(pattern, input);
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "Hello World!", // valid
            "Test123", // valid 
            "This is a valid input with some punctuation!", // valid
            "ab", // invalid - too short
            "This input contains invalid chars like $ and @ which are not allowed!" // invalid chars
        };
        
        for(String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Valid: " + validateInput(test));
            System.out.println();
        }
    }
}
