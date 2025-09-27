package CoT.claude;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task83 {
    public static String encryptKey(String keyToEncrypt, String secretKey) throws Exception {
        if (keyToEncrypt == null || secretKey == null) {
            throw new IllegalArgumentException("Input parameters cannot be null");
        }
        
        // Validate key length
        if (secretKey.length() != 16) {
            throw new IllegalArgumentException("Secret key must be 16 bytes");
        }

        // Generate random IV
        byte[] iv = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Create SecretKey
        SecretKey key = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");

        // Initialize cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);

        // Encrypt
        byte[] encrypted = cipher.doFinal(keyToEncrypt.getBytes("UTF-8"));
        
        // Combine IV and encrypted part
        byte[] encryptedIVAndText = new byte[iv.length + encrypted.length];
        System.arraycopy(iv, 0, encryptedIVAndText, 0, iv.length);
        System.arraycopy(encrypted, 0, encryptedIVAndText, iv.length, encrypted.length);

        return Base64.getEncoder().encodeToString(encryptedIVAndText);
    }

    public static void main(String[] args) {
        try {
            // Test cases
            String secretKey = "1234567890123456"; // 16-byte key
            
            // Test case 1: Normal input
            System.out.println("Test 1: " + encryptKey("Hello World!", secretKey));
            
            // Test case 2: Empty string
            System.out.println("Test 2: " + encryptKey("", secretKey));
            
            // Test case 3: Special characters
            System.out.println("Test 3: " + encryptKey("!@#$%^&*()", secretKey));
            
            // Test case 4: Long string
            System.out.println("Test 4: " + encryptKey("This is a very long string to encrypt", secretKey));
            
            // Test case 5: Numbers only
            System.out.println("Test 5: " + encryptKey("123456789", secretKey));
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
