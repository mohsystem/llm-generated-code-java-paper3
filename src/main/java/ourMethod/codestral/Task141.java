package ourMethod.codestral;
public class Task141 {
    public static String reverseString(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }

        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Hello, World!"));
        System.out.println(reverseString("1234567890"));
        System.out.println(reverseString(""));
        System.out.println(reverseString("a"));
        System.out.println(reverseString("ab"));
    }
}