package ZeroShot.claude;

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
        
        // Remove any potentially dangerous characters
        input = input.replaceAll("[^a-zA-Z0-9\\\\s]", "");
        
        return input.trim();
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "Hello World!",
            "Test@123#$%",
            null,
            "A".repeat(2000),
            "  Spaces  Test  "
        };
        
        for (String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Processed: " + processString(test));
            System.out.println();
        }
    }
}
