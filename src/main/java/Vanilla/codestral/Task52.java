package Vanilla.codestral;
public class Task52 {
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char)(((int)text.charAt(i) + shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char)(((int)text.charAt(i) + shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }

    public static void main(String[] args) {
        String text = "HELLO";
        int shift = 4;
        String encryptedText = encrypt(text, shift);
        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Original: " + text);
        System.out.println("Encrypted: " + encryptedText);
        System.out.println("Decrypted: " + decryptedText);
    }
}