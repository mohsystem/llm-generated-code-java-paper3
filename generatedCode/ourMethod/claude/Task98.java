package ourMethod.claude;

public class Task98 {
    public static Integer convertToInteger(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null;
        }
        
        try {
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
            System.out.println("Input: \\"" + test + "\\" -> Output: " + result);
        }
    }
}
