package Vanilla.claude;

public class Task114 {
    public static String stringOperations(String str1, String str2) {
        // Copy
        String copy = new String(str1);
        
        // Concatenate
        String concat = str1 + str2;
        
        // Convert to uppercase
        String upper = str1.toUpperCase();
        
        // Reverse
        String reverse = new StringBuilder(str1).reverse().toString();
        
        // Return all operations
        return "Copy: " + copy + "\\nConcatenated: " + concat + 
               "\\nUppercase: " + upper + "\\nReversed: " + reverse;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test 1:");
        System.out.println(stringOperations("hello", "world"));
        
        System.out.println("\\nTest 2:");
        System.out.println(stringOperations("Java", "Program"));
        
        System.out.println("\\nTest 3:");
        System.out.println(stringOperations("abc", "xyz"));
        
        System.out.println("\\nTest 4:");
        System.out.println(stringOperations("Test", "Case"));
        
        System.out.println("\\nTest 5:");
        System.out.println(stringOperations("String", "Ops"));
    }
}
