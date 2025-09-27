package CoT.claude;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Base64;

public class Task134 {
    private static final String ALGORITHM = "AES";
    private static final int KEY_SIZE = 256;
    
    public static String generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(KEY_SIZE, SecureRandom.getInstanceStrong());
        SecretKey key = keyGen.generateKey();
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    public static SecretKey loadKey(String encodedKey) {
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, ALGORITHM);
    }

    public static void main(String[] args) {
        try {
            // Test Case 1: Generate new key
            String key1 = generateKey();
            System.out.println("Generated Key 1: " + key1);
            
            // Test Case 2: Load generated key
            SecretKey loadedKey1 = loadKey(key1);
            System.out.println("Loaded Key 1 Algorithm: " + loadedKey1.getAlgorithm());
            
            // Test Case 3: Generate another key
            String key2 = generateKey();
            System.out.println("Generated Key 2: " + key2);
            
            // Test Case 4: Verify keys are different
            System.out.println("Keys are different: " + !key1.equals(key2));
            
            // Test Case 5: Key strength verification
            SecretKey loadedKey2 = loadKey(key2);
            System.out.println("Key strength (bits): " + loadedKey2.getEncoded().length * 8);
            
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Cryptographic algorithm not available: " + e.getMessage());
        }
    }
}
