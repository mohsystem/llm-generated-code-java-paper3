package ZeroShot.claude;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Task136 {
    private Map<String, String> users = new HashMap<>();
    
    // Hash password using SHA-256
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
    
    public boolean register(String username, String password) {
        if (username == null || password == null || username.trim().isEmpty() || 
            password.length() < 8 || users.containsKey(username)) {
            return false;
        }
        users.put(username, hashPassword(password));
        return true;
    }
    
    public boolean authenticate(String username, String password) {
        if (username == null || password == null || !users.containsKey(username)) {
            return false;
        }
        String hashedPassword = hashPassword(password);
        return users.get(username).equals(hashedPassword);
    }
    
    public static void main(String[] args) {
        Task136 auth = new Task136();
        
        // Test case 1: Successful registration
        System.out.println(auth.register("user1", "password123")); // true
        
        // Test case 2: Successful authentication
        System.out.println(auth.authenticate("user1", "password123")); // true
        
        // Test case 3: Failed authentication - wrong password
        System.out.println(auth.authenticate("user1", "wrongpass")); // false
        
        // Test case 4: Failed registration - username already exists
        System.out.println(auth.register("user1", "newpassword")); // false
        
        // Test case 5: Failed registration - password too short
        System.out.println(auth.register("user2", "short")); // false
    }
}
