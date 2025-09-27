package Vanilla.claude;

import java.util.regex.Pattern;

public class Task109 {
    public static boolean validateInput(String input) {
        // Validate that input:
        // - Starts with letter
        // - Contains only letters, numbers and underscore
        // - Is between 4-20 characters
        String pattern = "^[A-Za-z]\\\\w{3,19}$";
        return Pattern.matches(pattern, input);
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "User123",      // valid
            "123User",      // invalid - starts with number
            "Ab",          // invalid - too short
            "User_name_1", // valid
            "Very_long_username_123" // invalid - too long
        };
        
        for(String test : tests) {
            System.out.println("Input: " + test + " -> Valid: " + validateInput(test));
        }
    }
}
