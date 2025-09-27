package ourMethod.codestral;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Task79 {
    public static void main(String[] args) throws Exception {
        String message = "Hello, World!";
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
        String encryptedMessage = encrypt(message, secretKey);
        System.out.println("Encrypted message: " + encryptedMessage);
    }

    public static String encrypt(String message, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}