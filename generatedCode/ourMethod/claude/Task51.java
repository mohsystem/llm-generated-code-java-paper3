package ourMethod.claude;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task51 {
    private static final String ALGORITHM = "AES";
    private static final int KEY_LENGTH = 256;
    private static final int ITERATION_COUNT = 65536;
    
    public static String encrypt(String input, String password) throws Exception {
        if (input == null || password == null) {
            throw new IllegalArgumentException("Input and password cannot be null");
        }
        
        // Generate a random salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        
        // Generate key from password
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATION_COUNT, KEY_LENGTH);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKey key = new SecretKeySpec(tmp.getEncoded(), ALGORITHM);
        
        // Initialize cipher
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        
        // Encrypt
        byte[] encryptedBytes = cipher.doFinal(input.getBytes());
        
        // Combine salt and encrypted data
        byte[] combined = new byte[salt.length + encryptedBytes.length];
        System.arraycopy(salt, 0, combined, 0, salt.length);
        System.arraycopy(encryptedBytes, 0, combined, salt.length, encryptedBytes.length);
        
        return Base64.getEncoder().encodeToString(combined);
    }
    
    public static void main(String[] args) {
        try {
            // Test cases
            String[] inputs = {
                "Hello World!",
                "Sensitive Data 123",
                "Test@#$%^&*()",
                "Very Long String That Needs To Be Encrypted Securely",
                ""  // Empty string test
            };
            String password = "SecurePassword123!";
            
            for (String input : inputs) {
                String encrypted = encrypt(input, password);
                System.out.println("Input: " + input);
                System.out.println("Encrypted: " + encrypted);
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println("Encryption error: " + e.getMessage());
        }
    }
}
