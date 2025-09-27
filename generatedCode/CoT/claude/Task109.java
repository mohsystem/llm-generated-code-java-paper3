package CoT.claude;

import java.util.regex.Pattern;

public class Task109 {
    public static boolean validateInput(String input) {
        if(input == null || input.isEmpty()) {
            return false;
        }
        
        // Validate input contains only alphanumeric chars and is 5-20 chars long
        String regex = "^[a-zA-Z0-9]{5,20}$";
        return Pattern.matches(regex, input);
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "abc123",         // valid
            "test@123",       // invalid - special char
            "ab",            // invalid - too short  
            "abcdefghijklmnopqrstuvwxyz", // invalid - too long
            "ValidInput123"   // valid
        };
        
        for(String test : tests) {
            System.out.println("Input: " + test + " -> Valid: " + validateInput(test));
        }
    }
}
