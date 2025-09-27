package Vanilla.gpt4o;
public class Task141 {
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));  // Test case 1
        System.out.println(reverseString("world"));  // Test case 2
        System.out.println(reverseString("java"));   // Test case 3
        System.out.println(reverseString("python")); // Test case 4
        System.out.println(reverseString("cpp"));    // Test case 5
    }
}