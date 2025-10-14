package ourMethodv2.gpt4o;
public class Task114 {
    public static String copyString(String input) {
        return new String(input);
    }

    public static String concatenateStrings(String str1, String str2) {
        return str1 + str2;
    }

    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(copyString("Hello")); // Output: Hello
        System.out.println(concatenateStrings("Hello", "World")); // Output: HelloWorld
        System.out.println(reverseString("Hello")); // Output: olleH
        System.out.println(copyString("Java")); // Output: Java
        System.out.println(concatenateStrings("Java", "Program")); // Output: JavaProgram
    }
}