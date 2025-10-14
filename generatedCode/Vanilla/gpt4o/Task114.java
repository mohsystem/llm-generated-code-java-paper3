package Vanilla.openai;
public class Task114 {
    public static String copyString(String str) {
        return new String(str);
    }

    public static String concatenateStrings(String str1, String str2) {
        return str1 + str2;
    }

    public static String manipulateString(String str) {
        return str.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(copyString("Hello"));
        System.out.println(concatenateStrings("Hello", " World"));
        System.out.println(manipulateString("Hello"));
        System.out.println(copyString("Java"));
        System.out.println(concatenateStrings("Java", " Programming"));
    }
}