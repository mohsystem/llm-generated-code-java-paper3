package CoT.codestral;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Task79 {
    public static String encrypt(String message, String secretKey) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static void main(String[] args) throws Exception {
        String secretKey = "ThisIsASecretKey";
        String message = "This is a secret message.";
        String encryptedMessage = encrypt(message, secretKey);
        System.out.println("Encrypted message: " + encryptedMessage);
    }
}