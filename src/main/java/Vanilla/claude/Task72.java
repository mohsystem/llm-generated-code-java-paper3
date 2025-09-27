package Vanilla.claude;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Task72 {
    private static final byte[] IV = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final String KEY = "1234567890123456"; // 16 byte key
    
    public static String encrypt(String input) throws Exception {
        // Create IV
        IvParameterSpec ivSpec = new IvParameterSpec(IV);
        
        // Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), "AES");
        
        // Initialize cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        
        // Encrypt
        byte[] encrypted = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static void main(String[] args) {
        try {
            // Test cases
            String[] testCases = {
                "Hello World",
                "Test123",
                "Encryption Example",
                "AES CBC Mode",
                "SecurityTest"
            };
            
            for(int i = 0; i < testCases.length; i++) {
                String encrypted = encrypt(testCases[i]);
                System.out.println("Test Case " + (i+1) + ":");
                System.out.println("Input: " + testCases[i]);
                System.out.println("Encrypted: " + encrypted);
                System.out.println();
            }
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
