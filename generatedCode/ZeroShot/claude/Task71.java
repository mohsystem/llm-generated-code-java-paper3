package ZeroShot.claude;

public class Task71 {
    public static Integer convertToInteger(String input) {
        try {
            // Validate input
            if(input == null || input.trim().isEmpty()) {
                return null;
            }
            // Remove any whitespace
            input = input.trim();
            // Check if string contains only digits
            if(!input.matches("^-?\\\\d+$")) {
                return null;
            }
            // Convert to integer
            return Integer.parseInt(input);
        } catch(NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testInputs = {
            "123",
            "-456", 
            "abc",
            "12.34",
            ""
        };

        for(String input : testInputs) {
            Integer result = convertToInteger(input);
            System.out.println("Input: " + input);
            System.out.println("Result: " + (result != null ? result : "Invalid input"));
            System.out.println();
        }
    }
}
