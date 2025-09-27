package ourMethod.claude;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class Task42 {
    private static final int SALT_LENGTH = 32;
    private static final int MIN_PASSWORD_LENGTH = 8;
    private final Map<String, UserCredentials> users;
    private final SecureRandom random;
    
    private static class UserCredentials {
        private final byte[] passwordHash;
        private final byte[] salt;
        
        public UserCredentials(byte[] passwordHash, byte[] salt) {
            this.passwordHash = passwordHash.clone();
            this.salt = salt.clone();
        }
        
        public byte[] getPasswordHash() {
            return passwordHash.clone();
        }
        
        public byte[] getSalt() {
            return salt.clone();
        }
    }
    
    public Task42() {
        users = new HashMap<>();
        random = new SecureRandom();
    }
    
    public boolean register(String username, String password) {
        if (username == null || password == null || username.isEmpty() || password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }
        
        if (users.containsKey(username)) {
            return false;
        }
        
        byte[] salt = generateSalt();
        byte[] passwordHash = hashPassword(password, salt);
        
        users.put(username, new UserCredentials(passwordHash, salt));
        return true;
    }
    
    public boolean authenticate(String username, String password) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return false;
        }
        
        UserCredentials user = users.get(username);
        if (user == null) {
            return false;
        }
        
        byte[] hash = hashPassword(password, user.getSalt());
        return MessageDigest.isEqual(hash, user.getPasswordHash());
    }
    
    private byte[] generateSalt() {
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return salt;
    }
    
    private byte[] hashPassword(String password, byte[] salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(salt);
            return digest.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public static void main(String[] args) {
        Task42 auth = new Task42();
        
        // Test case 1: Register new user
        System.out.println("Test 1: " + auth.register("user1", "password123")); // Should return true
        
        // Test case 2: Register duplicate user
        System.out.println("Test 2: " + auth.register("user1", "password456")); // Should return false
        
        // Test case 3: Register with invalid password
        System.out.println("Test 3: " + auth.register("user2", "pass")); // Should return false
        
        // Test case 4: Authenticate valid user
        System.out.println("Test 4: " + auth.authenticate("user1", "password123")); // Should return true
        
        // Test case 5: Authenticate with wrong password
        System.out.println("Test 5: " + auth.authenticate("user1", "wrongpass")); // Should return false
    }
}
