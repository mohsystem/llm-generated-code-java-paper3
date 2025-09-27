package ourMethod.gpt4o;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task79 {
    public static String encrypt(String message, String secret) throws Exception {
        byte[] key = secret.getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        key = sha.digest(key);
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encrypted = cipher.doFinal(message.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static void main(String[] args) {
        try {
            String secret = "mysecretkey";
            System.out.println(encrypt("Hello, World!", secret));
            System.out.println(encrypt("Secure Message", secret));
            System.out.println(encrypt("Java Encryption", secret));
            System.out.println(encrypt("Encrypt this text", secret));
            System.out.println(encrypt("Last test message", secret));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}