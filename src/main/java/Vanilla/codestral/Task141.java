package Vanilla.codestral;
public class Task141 {
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Hello, World!"));
        System.out.println(reverseString("12345"));
        System.out.println(reverseString("racecar"));
        System.out.println(reverseString(""));
        System.out.println(reverseString("a"));
    }
}