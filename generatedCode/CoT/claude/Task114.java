package CoT.claude;

public class Task114 {
    public static String stringOperations(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return "";
        }
        
        // Copy string
        String copy = new String(str1);
        
        // Concatenate strings
        String concat = str1 + str2;
        
        // Convert to uppercase
        String upper = str1.toUpperCase();
        
        // Reverse string
        StringBuilder reversed = new StringBuilder(str1).reverse();
        
        // Return all operations
        return "Copy: " + copy + "\\nConcatenated: " + concat + 
               "\\nUppercase: " + upper + "\\nReversed: " + reversed;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test 1:");
        System.out.println(stringOperations("hello", "world"));
        
        System.out.println("\\nTest 2:");
        System.out.println(stringOperations("Java", "Program"));
        
        System.out.println("\\nTest 3:");
        System.out.println(stringOperations("ABC", "xyz"));
        
        System.out.println("\\nTest 4:");
        System.out.println(stringOperations("12345", "67890"));
        
        System.out.println("\\nTest 5:");
        System.out.println(stringOperations("Test", "Case"));
    }
}
