package ourMethod.codestral;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class Task83 {
    public static void main(String[] args) throws Exception {
        String key = "This is a secret";
        String encryptedKey = encryptAES(key);
        System.out.println("Encrypted key: " + encryptedKey);
    }

    public static String encryptAES(String key) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedKey = cipher.doFinal(key.getBytes());
        return Base64.getEncoder().encodeToString(encryptedKey);
    }
}