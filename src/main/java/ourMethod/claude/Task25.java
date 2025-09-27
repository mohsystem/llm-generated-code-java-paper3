package ourMethod.claude;

public class Task25 {
    public static String[] addLineNumbers(String[] lines) {
        if (lines == null) {
            return new String[0];
        }
        
        String[] result = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            result[i] = (i + 1) + ": " + (lines[i] != null ? lines[i] : "");
        }
        return result;
    }
    
    public static void main(String[] args) {
        // Test cases
        String[][] tests = {
            {},
            {"a", "b", "c"},
            {"1", "2", "3", "4", "5"},
            {null, "test", null},
            {"Hello", "World!"}
        };
        
        for (String[] test : tests) {
            String[] result = addLineNumbers(test);
            System.out.println("Input: " + java.util.Arrays.toString(test));
            System.out.println("Output: " + java.util.Arrays.toString(result));
            System.out.println();
        }
    }
}
