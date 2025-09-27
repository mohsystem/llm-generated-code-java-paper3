package Vanilla.claude;

public class Task25 {
    public static String[] number(String[] lines) {
        String[] result = new String[lines.length];
        for(int i = 0; i < lines.length; i++) {
            result[i] = (i+1) + ": " + lines[i];
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        String[][] tests = {
            {}, // empty array
            {"a", "b", "c"},
            {"", "", ""},
            {"Hello", "World"},
            {"1", "2", "3", "4", "5"}
        };

        for(String[] test : tests) {
            System.out.println("Input: " + java.util.Arrays.toString(test));
            System.out.println("Output: " + java.util.Arrays.toString(number(test)));
            System.out.println();
        }
    }
}
