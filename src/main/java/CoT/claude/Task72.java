package CoT.claude;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class Task72 {
    private static final int KEY_SIZE = 16; // 128 bits
    private static final int BLOCK_SIZE = 16;
    private static byte[] iv = new byte[KEY_SIZE];
    
    static {
        // Create static IV securely
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(iv);
    }

    public static String encrypt(String data, String key) throws Exception {
        if (data == null || key == null) {
            throw new IllegalArgumentException("Input data and key cannot be null");
        }
        
        // Validate and pad key to 16 bytes
        byte[] keyBytes = Arrays.copyOf(key.getBytes("UTF-8"), KEY_SIZE);
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
        
        // Initialize cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        
        // Encrypt data
        byte[] encrypted = cipher.doFinal(data.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static void main(String[] args) {
        try {
            String key = "MySecretKey12345";
            
            // Test case 1: Normal string
            System.out.println("Test 1: " + encrypt("Hello World", key));
            
            // Test case 2: Empty string
            System.out.println("Test 2: " + encrypt("", key));
            
            // Test case 3: Long string
            System.out.println("Test 3: " + encrypt("This is a very long string for testing encryption", key));
            
            // Test case 4: Special characters
            System.out.println("Test 4: " + encrypt("!@#$%^&*()", key));
            
            // Test case 5: Numbers
            System.out.println("Test 5: " + encrypt("1234567890", key));
            
        } catch (Exception e) {
            System.err.println("Encryption error: " + e.getMessage());
        }
    }
}
