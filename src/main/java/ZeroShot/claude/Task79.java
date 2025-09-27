package ZeroShot.claude;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Task79 {
    public static String encrypt(String message, String secretKey) {
        try {
            // Create cipher instance
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            
            // Create secret key
            SecretKeySpec key = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");
            
            // Initialize cipher for encryption
            cipher.init(Cipher.ENCRYPT_MODE, key);
            
            // Encrypt the message
            byte[] encryptedBytes = cipher.doFinal(message.getBytes());
            
            // Encode to base64 string
            return Base64.getEncoder().encodeToString(encryptedBytes);
            
        } catch(Exception e) {
            return "Error encrypting message";
        }
    }

    public static void main(String[] args) {
        String key = "1234567890123456"; // 16 byte key for AES-128
        
        // Test cases
        String[] messages = {
            "Hello World",
            "Secret Message 123",
            "Confidential Data",
            "Test Message",
            "Encryption Test"
        };
        
        for(int i = 0; i < messages.length; i++) {
            System.out.println("Test case " + (i+1) + ":");
            System.out.println("Original: " + messages[i]);
            System.out.println("Encrypted: " + encrypt(messages[i], key));
            System.out.println();
        }
    }
}
