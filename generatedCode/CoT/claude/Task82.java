package CoT.claude;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Task82 {
    public static String hashPassword(String password, byte[] salt) {
        try {
            // Use SHA-256 algorithm
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // Add salt to the digest
            md.update(salt);
            
            // Add password bytes to digest
            byte[] hashedPassword = md.digest(password.getBytes());
            
            // Convert to base64 for string representation
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
    
    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public static void main(String[] args) {
        // Test cases
        String[] passwords = {
            "password123",
            "SecureP@ssw0rd",
            "MyP@ssw0rd123!",
            "C0mpl3x1ty",
            "S@lt3dH@sh"
        };
        
        for(String password : passwords) {
            byte[] salt = generateSalt();
            String hashedPassword = hashPassword(password, salt);
            System.out.println("Password: " + password);
            System.out.println("Salt: " + Base64.getEncoder().encodeToString(salt));
            System.out.println("Hashed: " + hashedPassword);
            System.out.println();
        }
    }
}
