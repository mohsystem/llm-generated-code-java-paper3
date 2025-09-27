package ZeroShot.claude;

public class Task25 {
    public static String[] numberLines(String[] lines) {
        if (lines == null || lines.length == 0) {
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
        String[] result1 = numberLines(test1);
        System.out.println("Test 1: " + java.util.Arrays.toString(result1));
        
        // Test case 2: Single line
        String[] test2 = {"a"};
        String[] result2 = numberLines(test2);
        System.out.println("Test 2: " + java.util.Arrays.toString(result2));
        
        // Test case 3: Multiple lines
        String[] test3 = {"a", "b", "c"};
        String[] result3 = numberLines(test3);
        System.out.println("Test 3: " + java.util.Arrays.toString(result3));
        
        // Test case 4: Lines with spaces
        String[] test4 = {"Line 1", "Line 2", "Line 3"};
        String[] result4 = numberLines(test4);
        System.out.println("Test 4: " + java.util.Arrays.toString(result4));
        
        // Test case 5: Lines with special characters
        String[] test5 = {"Hello!", "@World", "#Test"};
        String[] result5 = numberLines(test5);
        System.out.println("Test 5: " + java.util.Arrays.toString(result5));
    }
}
