package ourMethod.claude;

public class Task114 {
    public static String copyString(String input) {
        if (input == null) {
            return null;
        }
        return new String(input);
    }
    
    public static String concatenateStrings(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return null;
        }
        return str1 + str2;
    }
    
    public static String getSubstring(String input, int start, int end) {
        if (input == null || start < 0 || end > input.length() || start > end) {
            return null;
        }
        return input.substring(start, end);
    }
    
    public static boolean compareStrings(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.equals(str2);
    }
    
    public static void main(String[] args) {
        // Test case 1: Copy string
        System.out.println("Test 1: " + copyString("Hello"));
        
        // Test case 2: Concatenate strings
        System.out.println("Test 2: " + concatenateStrings("Hello ", "World"));
        
        // Test case 3: Get substring
        System.out.println("Test 3: " + getSubstring("Hello World", 0, 5));
        
        // Test case 4: Compare strings
        System.out.println("Test 4: " + compareStrings("Hello", "Hello"));
        
        // Test case 5: Null handling
        System.out.println("Test 5: " + concatenateStrings(null, "World"));
    }
}
