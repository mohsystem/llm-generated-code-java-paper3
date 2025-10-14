package ourMethod.openai;
public class Task141 {
    public static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder(input);
        return reversed.reverse().toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(reverseString("hello"));  // olleh
        System.out.println(reverseString("world"));  // dlrow
        System.out.println(reverseString("java"));   // avaj
        System.out.println(reverseString("python")); // nohtyp
        System.out.println(reverseString("cpp"));    // ppc
    }
}