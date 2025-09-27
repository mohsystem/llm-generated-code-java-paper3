package CoT.claude;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Task124 {
    private SecretKey secretKey;
    
    public Task124() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            this.secretKey = keyGen.generateKey();
        } catch (Exception e) {
            System.err.println("Error initializing encryption: " + e.getMessage());
        }
    }
    
    public String encryptData(String sensitiveData) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(sensitiveData.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            System.err.println("Error encrypting data: " + e.getMessage());
            return null;
        }
    }
    
    public String decryptData(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.err.println("Error decrypting data: " + e.getMessage());
            return null;
        }
    }
    
    public static void main(String[] args) {
        Task124 secureStorage = new Task124();
        
        // Test cases
        String[] testData = {
            "4532-7153-3790-4421",
            "John Doe,123-45-6789",
            "jane.doe@email.com",
            "1234-5678-9012-3456",
            "987-65-4321,Alice Smith"
        };
        
        for (String data : testData) {
            System.out.println("Original: " + data);
            String encrypted = secureStorage.encryptData(data);
            System.out.println("Encrypted: " + encrypted);
            String decrypted = secureStorage.decryptData(encrypted);
            System.out.println("Decrypted: " + decrypted);
            System.out.println();
        }
    }
}
