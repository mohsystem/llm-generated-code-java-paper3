package ourMethod.claude;

public class Task71 {
    public static Integer convertStringToInt(String input) {
        try {
            if (input == null || input.trim().isEmpty()) {
                return null;
            }
            // Remove any whitespace
            input = input.trim();
            // Check if string contains only digits
            if (!input.matches("^-?\\\\d+$")) {
                return null;
            }
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testInputs = {
            "123",      // Valid integer
            "-456",     // Valid negative integer
            "abc",      // Invalid - contains letters
            "12.34",    // Invalid - decimal number
            ""         // Invalid - empty string
        };

        // If command line args provided, use those instead of test cases
        String[] inputs = args.length > 0 ? args : testInputs;

        for (String input : inputs) {
            Integer result = convertStringToInt(input);
            System.out.println("Input: '" + input + "' -> Result: " + result);
        }
    }
}
