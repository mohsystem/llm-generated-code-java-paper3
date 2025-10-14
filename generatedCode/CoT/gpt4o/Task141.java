package CoT.openai;
public class Task141 {
    public static String reverseString(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello")); // "olleh"
        System.out.println(reverseString("world")); // "dlrow"
        System.out.println(reverseString("java"));  // "avaj"
        System.out.println(reverseString("python")); // "nohtyp"
        System.out.println(reverseString("c++")); // "++c"
    }
}