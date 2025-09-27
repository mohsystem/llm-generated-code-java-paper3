package CoT.codestral;
public class Task141 {
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Hello, World!")); // !dlroW ,olleH
        System.out.println(reverseString("12345")); // 54321
        System.out.println(reverseString("")); // empty string
        System.out.println(reverseString("a")); // a
        System.out.println(reverseString("ab")); // ba
    }
}