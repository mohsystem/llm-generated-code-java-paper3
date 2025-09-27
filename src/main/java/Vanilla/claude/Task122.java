package Vanilla.claude;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Task122 {
    private static HashMap<String, String> userPasswords = new HashMap<>();
    
    public static boolean signUp(String username, String password) {
        if(userPasswords.containsKey(username)) {
            return false;
        }
        
        String hashedPassword = hashPassword(password);
        userPasswords.put(username, hashedPassword);
        return true;
    }
    
    private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
            
        } catch (NoSuchAlgorithmException e) {
            return password; // Fallback to plain text if hashing fails
        }
    }
    
    public static void main(String[] args) {
        // Test Case 1: New user signup
        System.out.println("Test 1: " + signUp("user1", "pass123")); // Should return true
        
        // Test Case 2: Duplicate username
        System.out.println("Test 2: " + signUp("user1", "differentpass")); // Should return false
        
        // Test Case 3: Another new user
        System.out.println("Test 3: " + signUp("user2", "password456")); // Should return true
        
        // Test Case 4: Empty username
        System.out.println("Test 4: " + signUp("", "pass123")); // Should return true
        
        // Test Case 5: Empty password
        System.out.println("Test 5: " + signUp("user3", "")); // Should return true
    }
}
