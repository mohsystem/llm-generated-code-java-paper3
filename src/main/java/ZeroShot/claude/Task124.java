package ZeroShot.claude;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Task124 {
    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "MySuperSecretKey"; // Use secure key management in production
    
    public static String encrypt(String data) throws Exception {
        Key key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    
    public static String decrypt(String encryptedData) throws Exception {
        Key key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
        try {
            // Test case 1
            String cc1 = "4532-7153-3790-4421";
            String encrypted1 = encrypt(cc1);
            System.out.println("Test 1: " + encrypted1 + " -> " + decrypt(encrypted1));
            
            // Test case 2
            String cc2 = "SSN: 123-45-6789";
            String encrypted2 = encrypt(cc2);
            System.out.println("Test 2: " + encrypted2 + " -> " + decrypt(encrypted2));
            
            // Test case 3
            String cc3 = "Password123!@#";
            String encrypted3 = encrypt(cc3);
            System.out.println("Test 3: " + encrypted3 + " -> " + decrypt(encrypted3));
            
            // Test case 4
            String cc4 = "user@email.com";
            String encrypted4 = encrypt(cc4);
            System.out.println("Test 4: " + encrypted4 + " -> " + decrypt(encrypted4));
            
            // Test case 5
            String cc5 = "Account#: 7890123456";
            String encrypted5 = encrypt(cc5);
            System.out.println("Test 5: " + encrypted5 + " -> " + decrypt(encrypted5));
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
