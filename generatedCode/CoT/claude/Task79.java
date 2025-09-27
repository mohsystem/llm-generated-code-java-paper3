package CoT.claude;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Task79 {
    public static String encrypt(String message, String secretKey) {
        try {
            // Ensure key is 16 bytes
            byte[] key = new byte[16];
            byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
            System.arraycopy(keyBytes, 0, key, 0, Math.min(keyBytes.length, 16));
            
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            
            byte[] encryptedBytes = cipher.doFinal(message.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
            
        } catch (Exception e) {
            return "Encryption failed: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        String key = "MySecretKey12345";
        
        System.out.println("Test 1: " + encrypt("Hello World!", key));
        System.out.println("Test 2: " + encrypt("Secret Message", key));
        System.out.println("Test 3: " + encrypt("12345", key));
        System.out.println("Test 4: " + encrypt("Special @#$%", key));
        System.out.println("Test 5: " + encrypt("", key)); // Empty string test
    }
}
