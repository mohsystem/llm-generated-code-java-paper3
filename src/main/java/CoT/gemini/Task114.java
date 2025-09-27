package CoT.gemini;
import java.util.Arrays;

class Task114 {
    public static String copyString(String str) {
        char[] charArray = str.toCharArray();
        char[] copiedArray = Arrays.copyOf(charArray, charArray.length);
        return new String(copiedArray);
    }

    public static String concatenateStrings(String str1, String str2) {
        return str1 + str2;
    }

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println("Copy String: " + copyString("Hello"));
        System.out.println("Concatenate Strings: " + concatenateStrings("Hello", " World"));
        System.out.println("Reverse String: " + reverseString("Hello"));
        System.out.println("Copy String: " + copyString("OpenAI"));
        System.out.println("Concatenate Strings: " + concatenateStrings("Java", " Programming"));

    }
}