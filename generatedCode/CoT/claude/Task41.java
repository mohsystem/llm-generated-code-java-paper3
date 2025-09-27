package CoT.claude;

public class Task41 {
    public static String processString(String input) {
        if (input == null) {
            return "";
        }
        
        // Limit input length to prevent memory issues
        final int MAX_LENGTH = 1024;
        if (input.length() > MAX_LENGTH) {
            input = input.substring(0, MAX_LENGTH);
        }
        
        // Remove any non-printable characters
        input = input.replaceAll("[^\\\\x20-\\\\x7E]", "");
        
        // Simple processing: reverse the string
        StringBuilder reversed = new StringBuilder(input);
        return reversed.reverse().toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "Hello World!",
            "Test123@#$",
            "", // Empty string
            "A".repeat(2000), // Long string
            null // Null input
        };
        
        for (String test : tests) {
            System.out.println("Input: " + (test == null ? "null" : test));
            System.out.println("Output: " + processString(test));
            System.out.println();
        }
    }
}
