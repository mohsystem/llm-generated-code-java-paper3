package Vanilla.claude;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Task83 {
    public static String encrypt(String key, String input) throws Exception {
        byte[] keyBytes = key.getBytes("UTF-8");
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
        
        byte[] iv = new byte[16];
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        
        byte[] encrypted = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static void main(String[] args) {
        try {
            // Test cases
            String key = "1234567890123456"; // 16 byte key
            
            System.out.println("Test Case 1: " + encrypt(key, "Hello World"));
            System.out.println("Test Case 2: " + encrypt(key, "Testing123"));
            System.out.println("Test Case 3: " + encrypt(key, "SecureMessage"));
            System.out.println("Test Case 4: " + encrypt(key, "AES Encryption"));
            System.out.println("Test Case 5: " + encrypt(key, "CBC Mode Test"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
