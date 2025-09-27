package ZeroShot.codestral;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Task79 {
    public static void main(String[] args) throws Exception {
        String message = "Hello, World!";
        String secretKey = "MySecretKey";
        String encryptedMessage = encrypt(message, secretKey);
        System.out.println("Encrypted message: " + encryptedMessage);
    }

    public static String encrypt(String message, String secretKey) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKeyObj = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeyObj);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}