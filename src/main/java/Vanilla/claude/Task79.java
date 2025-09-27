package Vanilla.claude;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Task79 {
    public static String encrypt(String message, String key) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(message.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            return "Error in encryption";
        }
    }

    public static void main(String[] args) {
        String key = "1234567890123456"; // 16 byte key for AES
        
        // Test case 1
        System.out.println(encrypt("Hello World", key));
        
        // Test case 2
        System.out.println(encrypt("Secret Message", key));
        
        // Test case 3
        System.out.println(encrypt("12345", key));
        
        // Test case 4
        System.out.println(encrypt("Testing Encryption", key));
        
        // Test case 5
        System.out.println(encrypt("Special@Characters#123", key));
    }
}
