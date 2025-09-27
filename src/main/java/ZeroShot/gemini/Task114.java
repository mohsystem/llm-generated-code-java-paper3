package ZeroShot.gemini;
public class Task114 {

    public static String copyString(String str) {
        return new String(str);
    }

    public static String concatenateStrings(String str1, String str2) {
        return str1 + str2;
    }

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println("Copy: " + copyString("hello"));
        System.out.println("Concatenate: " + concatenateStrings("hello", " world"));
        System.out.println("Reverse: " + reverseString("hello"));
        System.out.println("Upper Case: " + toUpperCase("hello"));
        System.out.println("Concatenate null with string : " + concatenateStrings(null, " world"));
    }
}