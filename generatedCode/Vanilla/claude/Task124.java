package Vanilla.claude;

// Task124.java
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Task124 {
    public static String encryptData(String data) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();
        
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static void main(String[] args) {
        try {
            // Test cases
            String[] testData = {
                "4532-7153-3790-4421",
                "John Doe SSN: 123-45-6789", 
                "Account#: 987654321",
                "Password: Secret123!",
                "Address: 123 Main St"
            };

            for(String data : testData) {
                String encrypted = encryptData(data);
                System.out.println("Original: " + data);
                System.out.println("Encrypted: " + encrypted + "\n");
            }
        } catch(Exception e) {
            System.out.println("Encryption error: " + e.getMessage());
        }
    }
}
