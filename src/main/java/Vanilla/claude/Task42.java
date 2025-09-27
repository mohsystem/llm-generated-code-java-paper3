package Vanilla.claude;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Task42 {
    private static HashMap<String, String> users = new HashMap<>();
    
    public static boolean registerUser(String username, String password) {
        if(users.containsKey(username)) {
            return false;
        }
        String hashedPassword = hashPassword(password);
        users.put(username, hashedPassword);
        return true;
    }
    
    public static boolean authenticateUser(String username, String password) {
        if(!users.containsKey(username)) {
            return false;
        }
        String hashedPassword = hashPassword(password);
        return users.get(username).equals(hashedPassword);
    }
    
    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for(byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch(NoSuchAlgorithmException e) {
            return null;
        }
    }
    
    public static void main(String[] args) {
        // Test Case 1: Register new user
        System.out.println(registerUser("user1", "pass123")); // true
        
        // Test Case 2: Register duplicate user
        System.out.println(registerUser("user1", "pass456")); // false
        
        // Test Case 3: Authenticate with correct credentials
        System.out.println(authenticateUser("user1", "pass123")); // true
        
        // Test Case 4: Authenticate with wrong password
        System.out.println(authenticateUser("user1", "wrongpass")); // false
        
        // Test Case 5: Authenticate non-existent user
        System.out.println(authenticateUser("user2", "pass123")); // false
    }
}
