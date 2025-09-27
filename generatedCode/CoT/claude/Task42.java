package CoT.claude;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Base64;

public class Task42 {
    private static HashMap<String, UserCredentials> userDB = new HashMap<>();
    
    static class UserCredentials {
        private byte[] passwordHash;
        private byte[] salt;
        
        public UserCredentials(byte[] passwordHash, byte[] salt) {
            this.passwordHash = passwordHash;
            this.salt = salt;
        }
    }
    
    public static boolean registerUser(String username, String password) {
        if(username == null || password == null || username.trim().isEmpty() || password.length() < 8) {
            return false;
        }
        
        if(userDB.containsKey(username)) {
            return false;
        }
        
        try {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());
            
            userDB.put(username, new UserCredentials(hashedPassword, salt));
            return true;
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
    
    public static boolean authenticate(String username, String password) {
        if(username == null || password == null || !userDB.containsKey(username)) {
            return false;
        }
        
        try {
            UserCredentials user = userDB.get(username);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(user.salt);
            byte[] hashedPassword = md.digest(password.getBytes());
            
            return MessageDigest.isEqual(hashedPassword, user.passwordHash);
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        // Test case 1: Successful registration
        System.out.println(registerUser("user1", "password123")); // true
        
        // Test case 2: Duplicate registration
        System.out.println(registerUser("user1", "password456")); // false
        
        // Test case 3: Successful authentication
        System.out.println(authenticate("user1", "password123")); // true
        
        // Test case 4: Failed authentication - wrong password
        System.out.println(authenticate("user1", "wrongpassword")); // false
        
        // Test case 5: Failed authentication - non-existent user
        System.out.println(authenticate("user2", "password123")); // false
    }
}
