package ourMethod.claude;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task79 {
    private static final String ALGORITHM = "AES/CBC/PKCS5PADDING";
    
    public static String encryptMessage(String message, String key) throws Exception {
        if (message == null || key == null) {
            throw new IllegalArgumentException("Message and key cannot be null");
        }
        
        // Ensure key is exactly 16 bytes
        byte[] keyBytes = new byte[16];
        byte[] originalKey = key.getBytes("UTF-8");
        System.arraycopy(originalKey, 0, keyBytes, 0, Math.min(originalKey.length, keyBytes.length));
        
        // Generate IV
        SecureRandom secureRandom = new SecureRandom();
        byte[] iv = new byte[16];
        secureRandom.nextBytes(iv);
        
        // Create cipher
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivSpec);
        
        // Encrypt
        byte[] encrypted = cipher.doFinal(message.getBytes("UTF-8"));
        
        // Combine IV and encrypted part
        byte[] encryptedIVAndText = new byte[iv.length + encrypted.length];
        System.arraycopy(iv, 0, encryptedIVAndText, 0, iv.length);
        System.arraycopy(encrypted, 0, encryptedIVAndText, iv.length, encrypted.length);
        
        return Base64.getEncoder().encodeToString(encryptedIVAndText);
    }
    
    public static void main(String[] args) {
        try {
            // Test cases
            String[] messages = {
                "Hello World!",
                "Secret Message 123",
                "Confidential Data",
                "Test Message",
                "Security is important"
            };
            String key = "MySecretKey12345";
            
            for (String message : messages) {
                String encrypted = encryptMessage(message, key);
                System.out.println("Original: " + message);
                System.out.println("Encrypted: " + encrypted);
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println("Encryption error: " + e.getMessage());
        }
    }
}
