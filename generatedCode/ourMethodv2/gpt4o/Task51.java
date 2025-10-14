package ourMethodv2.gpt4o;
import java.security.SecureRandom;
import java.util.Base64;

public class Task51 {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String encryptString(String input, String key) {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char charToEncrypt = input.charAt(i);
            char keyChar = key.charAt(i % key.length());
            char encryptedChar = (char) (charToEncrypt + keyChar % ALPHABET.length());
            encrypted.append(encryptedChar);
        }

        return Base64.getEncoder().encodeToString(encrypted.toString().getBytes());
    }

    public static void main(String[] args) {
        String key = "secureKey";
        System.out.println(encryptString("HelloWorld", key));
        System.out.println(encryptString("JavaEncryption", key));
        System.out.println(encryptString("Secure123", key));
        System.out.println(encryptString("OpenAI", key));
        System.out.println(encryptString("EncryptionTest", key));
    }
}