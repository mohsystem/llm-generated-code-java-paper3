package ourMethod.claude;

public class Task44 {
    // Method to validate and process input
    public static String processInput(String input) {
        // Input validation
        if (input == null || input.trim().isEmpty()) {
            return "Invalid input: Input cannot be empty";
        }

        // Check length
        if (input.length() > 100) {
            return "Invalid input: Input too long (max 100 chars)";
        }

        // Check for invalid characters
        if (!input.matches("^[a-zA-Z0-9\\\\s]+$")) {
            return "Invalid input: Only alphanumeric characters allowed";
        }

        // Process valid input
        String result = input.trim().toUpperCase();
        return "Processed input: " + result;
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "Hello World",
            "", // Empty input
            "Test123!@#", // Invalid chars
            "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop", // Too long
            null, // Null input
            "Java Programming"
        };

        for (String test : tests) {
            System.out.println("Input: " + test);
            System.out.println(processInput(test));
            System.out.println();
        }
    }
}
