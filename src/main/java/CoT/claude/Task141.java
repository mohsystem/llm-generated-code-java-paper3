package CoT.claude;

public class Task141 {
    public static String reverseString(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "Hello World",
            "Java Programming",
            "12345",
            "",
            "a"
        };
        
        for (String test : tests) {
            System.out.println("Original: " + test);
            System.out.println("Reversed: " + reverseString(test));
            System.out.println();
        }
    }
}
