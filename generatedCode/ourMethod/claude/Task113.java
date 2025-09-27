package ourMethod.claude;

public class Task113 {
    public static String concatenateStrings(String[] inputs) {
        // Input validation
        if (inputs == null || inputs.length == 0) {
            return "";
        }
        
        // Use StringBuilder for efficient string concatenation
        StringBuilder result = new StringBuilder();
        
        // Iterate through inputs and append each string
        for (String str : inputs) {
            if (str != null) {
                result.append(str);
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println("Test 1: " + concatenateStrings(new String[]{"Hello", " ", "World"})); // Hello World
        System.out.println("Test 2: " + concatenateStrings(new String[]{"Java", "Script"})); // JavaScript
        System.out.println("Test 3: " + concatenateStrings(new String[]{null, "Test"})); // Test
        System.out.println("Test 4: " + concatenateStrings(new String[]{})); // Empty string
        System.out.println("Test 5: " + concatenateStrings(null)); // Empty string
    }
}
