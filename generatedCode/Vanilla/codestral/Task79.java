package Vanilla.codestral;
public class Task79 {
    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) + key - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) text.charAt(i) + key - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("HELLO", 3)); // Expected output: "KHOOR"
        System.out.println(encrypt("WORLD", 5)); // Expected output: "BTWQI"
        System.out.println(encrypt("JAVA", 10)); // Expected output: "TFKO"
        System.out.println(encrypt("PROGRAMMING", 15)); // Expected output: "UWLYHTTVRZZL"
        System.out.println(encrypt("CYBERSECURITY", 20)); // Expected output: "GCEVWICYVCUBC"
    }
}