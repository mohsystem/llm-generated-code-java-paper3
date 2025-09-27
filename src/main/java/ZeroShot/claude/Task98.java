package ZeroShot.claude;

public class Task98 {
    public static Integer convertToInteger(String input) {
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
            "12.34"
        };
        
        for(String test : tests) {
            Integer result = convertToInteger(test);
            if(result != null) {
                System.out.println("Input: " + test + " -> Successfully converted to: " + result);
            } else {
                System.out.println("Input: " + test + " -> Invalid integer format");
            }
        }
    }
}
