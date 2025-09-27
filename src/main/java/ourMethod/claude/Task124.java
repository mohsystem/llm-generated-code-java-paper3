package ourMethod.claude;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;
import java.io.*;

public class Task124 {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static SecretKey secretKey;
    private static byte[] iv;
    
    static {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            secretKey = keyGen.generateKey();
            
            SecureRandom secureRandom = new SecureRandom();
            iv = new byte[16];
            secureRandom.nextBytes(iv);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Encryption initialization failed", e);
        }
    }

    private static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
        try {
            // Test cases
            String[] sensitiveData = {
                "4532-7153-3790-4421",
                "John Doe,123-45-6789",
                "jane.doe@email.com,555-0123", 
                "4024-0071-5336-1892",
                "9238-4739-4012-7493"
            };
            
            Map<String, String> encryptedStorage = new HashMap<>();
            
            // Encrypt and store data
            for(int i = 0; i < sensitiveData.length; i++) {
                String key = "data" + i;
                String encryptedValue = encrypt(sensitiveData[i]);
                encryptedStorage.put(key, encryptedValue);
                System.out.println("Stored encrypted data " + i);
            }
            
            // Retrieve and decrypt data
            for(int i = 0; i < sensitiveData.length; i++) {
                String key = "data" + i;
                String encryptedValue = encryptedStorage.get(key);
                String decryptedValue = decrypt(encryptedValue);
                System.out.println("Retrieved and decrypted data " + i + ": " + decryptedValue);
            }

        } catch (Exception e) {
            System.err.println("Error processing sensitive data: " + e.getMessage());
        }
    }
}
