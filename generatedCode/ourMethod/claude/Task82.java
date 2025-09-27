package ourMethod.claude;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Task82 {
    // Use SHA-256 algorithm for hashing
    private static final String HASH_ALGORITHM = "SHA-256";
    private static final int SALT_LENGTH = 32; // 256 bits
    
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        // Generate random salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        
        // Combine password and salt
        MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
        digest.update(salt);
        byte[] hashedBytes = digest.digest(password.getBytes());
        
        // Combine salt and hash, encode as base64
        byte[] saltAndHash = new byte[salt.length + hashedBytes.length];
        System.arraycopy(salt, 0, saltAndHash, 0, salt.length);
        System.arraycopy(hashedBytes, 0, saltAndHash, salt.length, hashedBytes.length);
        
        return Base64.getEncoder().encodeToString(saltAndHash);
    }

    public static void main(String[] args) {
        try {
            // Test cases
            System.out.println("Hash 1: " + hashPassword("password123"));
            System.out.println("Hash 2: " + hashPassword("password123")); // Different salt = different hash
            System.out.println("Hash 3: " + hashPassword("Password123"));
            System.out.println("Hash 4: " + hashPassword(""));
            System.out.println("Hash 5: " + hashPassword("verylongpasswordthatisverylongindeed"));
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Hashing algorithm not available: " + e.getMessage());
        }
    }
}
