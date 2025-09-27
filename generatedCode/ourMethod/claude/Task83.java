package ourMethod.claude;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task83 {
    public static String encryptAESCBC(String key) throws Exception {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Key cannot be null or empty");
        }
        
        // Generate a secure random IV
        SecureRandom secureRandom = new SecureRandom();
        byte[] iv = new byte[16];
        secureRandom.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        
        // Generate AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256, secureRandom);
        SecretKey secretKey = keyGen.generateKey();
        
        // Create and initialize cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        
        // Encrypt
        byte[] encrypted = cipher.doFinal(key.getBytes("UTF-8"));
        
        // Combine IV and encrypted part
        byte[] encryptedIVAndText = new byte[iv.length + encrypted.length];
        System.arraycopy(iv, 0, encryptedIVAndText, 0, iv.length);
        System.arraycopy(encrypted, 0, encryptedIVAndText, iv.length, encrypted.length);
        
        return Base64.getEncoder().encodeToString(encryptedIVAndText);
    }
    
    public static void main(String[] args) {
        try {
            // Test cases
            System.out.println("Test 1: " + encryptAESCBC("MySecretKey123"));
            System.out.println("Test 2: " + encryptAESCBC("AnotherKey456"));
            System.out.println("Test 3: " + encryptAESCBC("TestKey789"));
            System.out.println("Test 4: " + encryptAESCBC("SecurePassword"));
            System.out.println("Test 5: " + encryptAESCBC("EncryptThis!"));
        } catch (Exception e) {
            System.err.println("Encryption error: " + e.getMessage());
        }
    }
}
