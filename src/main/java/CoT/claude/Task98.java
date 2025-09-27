package CoT.claude;

public class Task98 {
    public static Integer convertToInteger(String input) {
        try {
            if (input == null || input.trim().isEmpty()) {
                return null;
            }
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "123",
            "-456", 
            "0",
            "abc",
            ""
        };
        
        for (String test : tests) {
            Integer result = convertToInteger(test);
            System.out.println("Input: '" + test + "' -> Result: " + 
                (result != null ? result : "Invalid input"));
        }
    }
}
