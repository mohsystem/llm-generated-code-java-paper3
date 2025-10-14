import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Task79 {

    public static String encryptMessage(String message, byte[] secretKey) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(secretKey, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();
        byte[] keyBytes = secretKey.getEncoded();

        String[] testMessages = {
            "Hello, World!",
            "Java Encryption",
            "Secure Message",
            "Test 12345",
            "Final Test Case"
        };

        for (String message : testMessages) {
            String encryptedMessage = encryptMessage(message, keyBytes);
            System.out.println("Original: " + message + " | Encrypted: " + encryptedMessage);
        }
    }
}