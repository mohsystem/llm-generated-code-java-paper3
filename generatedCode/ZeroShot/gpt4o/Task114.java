package ZeroShot.openai;
public class Task114 {

    public static String copyString(String input) {
        if (input == null) return null;
        return new String(input);
    }

    public static String concatenateStrings(String str1, String str2) {
        if (str1 == null) str1 = "";
        if (str2 == null) str2 = "";
        return str1.concat(str2);
    }

    public static String reverseString(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(copyString("hello")); // hello
        System.out.println(copyString(null)); // null
        System.out.println(concatenateStrings("hello", "world")); // helloworld
        System.out.println(concatenateStrings(null, "world")); // world
        System.out.println(reverseString("hello")); // olleh
    }
}