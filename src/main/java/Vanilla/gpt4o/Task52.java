package Vanilla.gpt4o;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class Task52 {
    
    private static final String ALGORITHM = "AES";

    public static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static String decrypt(String encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData);
    }

    public static void main(String[] args) throws Exception {
        // Generate a key for testing
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();
        
        // Test cases
        String[] testCases = {
            "Hello World!",
            "Java Programming",
            "1234567890",
            "Encrypt this text",
            "Final Test Case"
        };
        
        for (String testCase : testCases) {
            String encrypted = encrypt(testCase, secretKey);
            String decrypted = decrypt(encrypted, secretKey);
            System.out.println("Original: " + testCase);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
            System.out.println();
        }
    }
}