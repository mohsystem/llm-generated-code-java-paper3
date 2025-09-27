package Vanilla.codestral;
public class Task114 {
    public static void main(String[] args) {
        System.out.println(copyString("Hello"));
        System.out.println(concatenateStrings("Hello", "World"));
        System.out.println(manipulateString("HelloWorld"));
    }

    public static String copyString(String input) {
        return new String(input);
    }

    public static String concatenateStrings(String str1, String str2) {
        return str1 + " " + str2;
    }

    public static String manipulateString(String input) {
        return input.substring(0, 5) + input.substring(5).toUpperCase();
    }
}