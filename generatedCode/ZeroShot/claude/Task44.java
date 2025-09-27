package ZeroShot.claude;

public class Task44 {
    public static String processUserInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Invalid input";
        }
        
        // Remove any special characters and limit length
        String sanitized = input.replaceAll("[^a-zA-Z0-9\\\\s]", "");
        if (sanitized.length() > 100) {
            sanitized = sanitized.substring(0, 100);
        }
        
        // Simple operation - reverse the string
        StringBuilder result = new StringBuilder(sanitized);
        return result.reverse().toString();
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "Hello World!",
            "Test@123",
            "",
            "ThisIsAVeryLongInputStringThatShouldBeTruncated" + "X".repeat(200),
            "<script>alert('xss')</script>"
        };
        
        for (String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Output: " + processUserInput(test));
            System.out.println();
        }
    }
}
