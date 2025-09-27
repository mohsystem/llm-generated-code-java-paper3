package Vanilla.gemini;
public class Task114 {

    public static String stringOperations(String str1, String str2, String operation) {
        switch (operation) {
            case "copy":
                return str1;
            case "concatenate":
                return str1 + str2;
            case "reverse":
                return new StringBuilder(str1).reverse().toString();
            default:
                return "Invalid operation";
        }
    }

    public static void main(String[] args) {
        System.out.println(stringOperations("hello", "world", "copy")); // hello
        System.out.println(stringOperations("hello", "world", "concatenate")); // helloworld
        System.out.println(stringOperations("hello", "world", "reverse")); // olleh
        System.out.println(stringOperations("coding", "challenge", "copy")); // coding
        System.out.println(stringOperations("open", "ai", "concatenate")); // openai
    }
}