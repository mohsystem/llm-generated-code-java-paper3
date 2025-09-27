package Vanilla.claude;

public class Task141 {
    public static String reverseString(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String[] testCases = {
            "Hello World",
            "Programming",
            "12345",
            "a",
            ""
        };
        
        for (String test : testCases) {
            System.out.println("Original: " + test);
            System.out.println("Reversed: " + reverseString(test));
            System.out.println();
        }
    }
}
