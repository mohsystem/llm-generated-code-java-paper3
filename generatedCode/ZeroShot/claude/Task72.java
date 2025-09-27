package ZeroShot.claude;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task72 {
    private static final byte[] IV = new byte[16]; // Static IV filled with zeros
    
    public static String encrypt(String plaintext, String key) throws Exception {
        // Create SecretKeySpec
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        
        // Initialize cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivSpec = new IvParameterSpec(IV);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        
        // Encrypt
        byte[] encrypted = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static void main(String[] args) {
        try {
            String key = "1234567890123456"; // 16 byte key
            
            // Test cases
            String[] testCases = {
                "Hello World!",
                "Secure Programming",
                "Test Case 3",
                "Encryption Test",
                "Final Test Case"
            };
            
            for(int i = 0; i < testCases.length; i++) {
                String encrypted = encrypt(testCases[i], key);
                System.out.println("Test case " + (i+1) + ":");
                System.out.println("Original: " + testCases[i]);
                System.out.println("Encrypted: " + encrypted);
                System.out.println();
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
