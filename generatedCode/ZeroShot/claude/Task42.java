package ZeroShot.claude;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Task42 {
    private static Map<String, String> userDatabase = new HashMap<>();
    
    public static boolean registerUser(String username, String password) {
        if(username == null || password == null || username.trim().isEmpty() || password.trim().isEmpty()) {
            return false;
        }
        
        if(userDatabase.containsKey(username)) {
            return false;
        }
        
        String hashedPassword = hashPassword(password);
        userDatabase.put(username, hashedPassword);
        return true;
    }
    
    public static boolean authenticateUser(String username, String password) {
        if(username == null || password == null || !userDatabase.containsKey(username)) {
            return false;
        }
        
        String storedHash = userDatabase.get(username);
        String inputHash = hashPassword(password);
        
        return storedHash.equals(inputHash);
    }
    
    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            
            for(byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch(NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) {
        // Test case 1: Successful registration
        System.out.println(registerUser("user1", "password123")); // true
        
        // Test case 2: Duplicate registration
        System.out.println(registerUser("user1", "password123")); // false
        
        // Test case 3: Successful authentication
        System.out.println(authenticateUser("user1", "password123")); // true
        
        // Test case 4: Failed authentication - wrong password
        System.out.println(authenticateUser("user1", "wrongpassword")); // false
        
        // Test case 5: Failed authentication - non-existent user
        System.out.println(authenticateUser("user2", "password123")); // false
    }
}
