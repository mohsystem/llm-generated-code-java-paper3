package ZeroShot.openai;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Task79 {
    public static String encryptMessage(String message, SecretKey secretKey) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(message.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Encryption failed", e);
        }
    }
    
    public static void main(String[] args) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
            
            System.out.println(encryptMessage("Hello", secretKey));
            System.out.println(encryptMessage("World", secretKey));
            System.out.println(encryptMessage("Java", secretKey));
            System.out.println(encryptMessage("Encryption", secretKey));
            System.out.println(encryptMessage("Test", secretKey));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}