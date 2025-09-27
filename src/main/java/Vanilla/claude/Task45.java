package Vanilla.claude;

class Task45 {
    public static String processInput(String input) {
        try {
            if (input == null || input.trim().isEmpty()) {
                throw new IllegalArgumentException("Input cannot be empty");
            }
            
            // Convert to integer
            int num = Integer.parseInt(input);
            
            if (num < 0) {
                throw new IllegalArgumentException("Number cannot be negative");
            }
            
            // Perform some operations
            int result = num * 2;
            return "Success: " + result;
            
        } catch (NumberFormatException e) {
            return "Error: Input must be a valid number";
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        } catch (Exception e) {
            return "Error: Unknown error occurred";
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "123",      // Valid number
            "-5",       // Negative number
            "abc",      // Invalid number
            "",        // Empty input
            null       // Null input
        };
        
        for(String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Output: " + processInput(test));
            System.out.println();
        }
    }
}
