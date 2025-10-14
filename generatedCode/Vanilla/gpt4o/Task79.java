package Vanilla.openai;
public class Task79 {
    public static String encryptMessage(String message, String key) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            char k = key.charAt(i % key.length());
            encrypted.append((char)(c + k));
        }
        return encrypted.toString();
    }

    public static void main(String[] args) {
        System.out.println(encryptMessage("hello", "key")); // Test case 1
        System.out.println(encryptMessage("world", "abc")); // Test case 2
        System.out.println(encryptMessage("java", "123"));  // Test case 3
        System.out.println(encryptMessage("encryption", "secret")); // Test case 4
        System.out.println(encryptMessage("message", "keykey")); // Test case 5
    }
}