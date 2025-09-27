package CoT.claude;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Task122 {
    private static Map<String, UserCredentials> userStore = new HashMap<>();
    
    private static class UserCredentials {
        private byte[] passwordHash;
        private byte[] salt;
        
        public UserCredentials(byte[] passwordHash, byte[] salt) {
            this.passwordHash = passwordHash;
            this.salt = salt;
        }
    }
    
    public static boolean signup(String username, String password) {
        if(username == null || password == null || username.trim().isEmpty() || password.trim().isEmpty()) {
            return false;
        }
        
        if(userStore.containsKey(username)) {
            return false;
        }
        
        try {
            // Generate random salt
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            
            // Hash password with salt
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());
            
            // Store credentials
            userStore.put(username, new UserCredentials(hashedPassword, salt));
            return true;
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println("Test 1: " + signup("user1", "password123")); // Should return true
        System.out.println("Test 2: " + signup("user1", "password456")); // Should return false (duplicate username)
        System.out.println("Test 3: " + signup("", "password789")); // Should return false (empty username)
        System.out.println("Test 4: " + signup("user2", "")); // Should return false (empty password)
        System.out.println("Test 5: " + signup("user3", "strongpassword")); // Should return true
    }
}
