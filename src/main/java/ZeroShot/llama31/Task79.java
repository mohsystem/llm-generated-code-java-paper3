package ZeroShot.llama31;
public class Task79 {
    public static StringBuffer encrypt(String text, int s) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char)(((int)text.charAt(i) + s - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char)(((int)text.charAt(i) + s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "ATTACKATONCE";
        int s = 4;
        System.out.println("Text : " + text);
        System.out.println("Shift : " + s);
        System.out.println("Cipher: " + encrypt(text, s));

        // Test cases
        System.out.println("Test Case 1:");
        System.out.println("Text : HELLO");
        System.out.println("Shift : 3");
        System.out.println("Cipher: " + encrypt("HELLO", 3));

        System.out.println("Test Case 2:");
        System.out.println("Text : WORLD");
        System.out.println("Shift : 1");
        System.out.println("Cipher: " + encrypt("WORLD", 1));

        System.out.println("Test Case 3:");
        System.out.println("Text : abcdef");
        System.out.println("Shift : 2");
        System.out.println("Cipher: " + encrypt("abcdef", 2));

        System.out.println("Test Case 4:");
        System.out.println("Text : ABCDEF");
        System.out.println("Shift : 5");
        System.out.println("Cipher: " + encrypt("ABCDEF", 5));

        System.out.println("Test Case 5:");
        System.out.println("Text : Hello, World!");
        System.out.println("Shift : 7");
        System.out.println("Cipher: " + encrypt("Hello, World!", 7));
    }
}