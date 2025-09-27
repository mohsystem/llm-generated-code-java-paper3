package ZeroShot.claude;

import java.util.Scanner;

public class Task45 {
    public static String processInput(String input) {
        if (input == null) {
            return "Error: Input is null";
        }
        
        try {
            // Remove any leading/trailing whitespace
            input = input.trim();
            
            if (input.isEmpty()) {
                return "Error: Input is empty";
            }
            
            // Convert to uppercase and reverse
            String result = new StringBuilder(input.toUpperCase()).reverse().toString();
            
            // Only allow alphanumeric
            if (!result.matches("^[a-zA-Z0-9\\\\s]+$")) {
                return "Error: Input contains invalid characters";
            }
            
            return result;
            
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "Hello World",
            "",
            null,
            "Test123",
            "Invalid@#$"
        };
        
        for (String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Output: " + processInput(test));
            System.out.println();
        }
    }
}
