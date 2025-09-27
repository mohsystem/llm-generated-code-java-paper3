package ZeroShot.claude;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;

public class Task122 {
    private static HashMap<String, UserCredentials> userDb = new HashMap<>();
    
    static class UserCredentials {
        String passwordHash;
        String salt;
        
        UserCredentials(String passwordHash, String salt) {
            this.passwordHash = passwordHash;
            this.salt = salt;
        }
    }
    
    public static boolean signup(String username, String password) {
        if(username == null || password == null || username.trim().isEmpty() || 
           password.length() < 8 || userDb.containsKey(username)) {
            return false;
        }
        
        try {
            // Generate random salt
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            String saltStr = Base64.getEncoder().encodeToString(salt);
            
            // Hash password with salt
            String hashedPassword = hashPassword(password, salt);
            
            // Store credentials
            userDb.put(username, new UserCredentials(hashedPassword, saltStr));
            return true;
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
    
    private static String hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }
    
    public static void main(String[] args) {
        // Test case 1: Valid signup
        System.out.println("Test 1: " + signup("user1", "strongpass123"));
        
        // Test case 2: Duplicate username
        System.out.println("Test 2: " + signup("user1", "anotherpass456"));
        
        // Test case 3: Password too short
        System.out.println("Test 3: " + signup("user2", "short"));
        
        // Test case 4: Empty username
        System.out.println("Test 4: " + signup("", "validpass123"));
        
        // Test case 5: Null values
        System.out.println("Test 5: " + signup(null, null));
    }
}
