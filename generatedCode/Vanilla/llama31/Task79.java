package Vanilla.llama31;
public class Task79 {
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isUpperCase(ch)) {
                ch = (char)(((int)ch + shift - 65) % 26 + 65);
            } else if (Character.isLowerCase(ch)) {
                ch = (char)(((int)ch + shift - 97) % 26 + 97);
            }
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] texts = {"ATTACKATONCE", "HelloWorld", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "abcdefghijklmnopqrstuvwxyz", "MixedCase123"};
        int[] shifts = {4, 3, 1, 5, 2};
        for (int i = 0; i < texts.length; i++) {
            System.out.println("Text : " + texts[i]);
            System.out.println("Shift : " + shifts[i]);
            System.out.println("Cipher: " + encrypt(texts[i], shifts[i]));
            System.out.println();
        }
    }
}