package CoT.gpt4o;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Task79 {
    public static String encrypt(String message, String secretKey) {
        try {
            byte[] decodedKey = Base64.getDecoder().decode(secretKey);
            SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, originalKey);

            byte[] encryptedBytes = cipher.doFinal(message.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Generate a random AES key for testing purposes
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();
            String base64Key = Base64.getEncoder().encodeToString(secretKey.getEncoded());

            // Test cases
            System.out.println(encrypt("Hello World", base64Key));
            System.out.println(encrypt("Java Encryption", base64Key));
            System.out.println(encrypt("Secure Message", base64Key));
            System.out.println(encrypt("Encrypt this text", base64Key));
            System.out.println(encrypt("Sample Test", base64Key));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}