package Vanilla.claude;

public class Task98 {
    public static Integer convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {"123", "-456", "0", "abc", "12.34"};
        
        for(String test : tests) {
            Integer result = convertToInteger(test);
            if(result != null) {
                System.out.println("Successfully converted '" + test + "' to: " + result);
            } else {
                System.out.println("Failed to convert: '" + test + "'");
            }
        }
    }
}
