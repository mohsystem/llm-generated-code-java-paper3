package CoT.claude;

import java.util.Arrays;

public class Task25 {
    public static String[] addLineNumbers(String[] lines) {
        if (lines == null) {
            return new String[0];
        }
        
        String[] result = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            result[i] = (i + 1) + ": " + lines[i];
        }
        return result;
    }
    
    public static void main(String[] args) {
        // Test case 1: Empty array
        String[] test1 = {};
        System.out.println("Test 1: " + Arrays.toString(addLineNumbers(test1)));
        
        // Test case 2: Array with three elements
        String[] test2 = {"a", "b", "c"};
        System.out.println("Test 2: " + Arrays.toString(addLineNumbers(test2)));
        
        // Test case 3: Array with one element
        String[] test3 = {"hello"};
        System.out.println("Test 3: " + Arrays.toString(addLineNumbers(test3)));
        
        // Test case 4: Array with special characters
        String[] test4 = {"*", "#", "@"};
        System.out.println("Test 4: " + Arrays.toString(addLineNumbers(test4)));
        
        // Test case 5: Array with longer strings
        String[] test5 = {"Line one", "Line two", "Line three"};
        System.out.println("Test 5: " + Arrays.toString(addLineNumbers(test5)));
    }
}
