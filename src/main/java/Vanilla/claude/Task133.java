package Vanilla.claude;

import java.util.HashMap;

public class Task133 {
    private static HashMap<String, String> users = new HashMap<>();
    
    public static boolean resetPassword(String username, String oldPassword, String newPassword) {
        if (!users.containsKey(username)) {
            return false;
        }
        
        if (!users.get(username).equals(oldPassword)) {
            return false;
        }
        
        if (newPassword.length() < 8) {
            return false;
        }
        
        users.put(username, newPassword);
        return true;
    }

    public static void addUser(String username, String password) {
        users.put(username, password);
    }

    public static void main(String[] args) {
        // Test cases
        addUser("user1", "password123");
        addUser("user2", "abc123xyz");
        addUser("user3", "securepass");
        
        // Test case 1: Valid password reset
        System.out.println(resetPassword("user1", "password123", "newpass123")); // true
        
        // Test case 2: Wrong old password
        System.out.println(resetPassword("user2", "wrongpass", "newpass456")); // false
        
        // Test case 3: User doesn't exist
        System.out.println(resetPassword("user4", "anypass", "newpass789")); // false
        
        // Test case 4: New password too short
        System.out.println(resetPassword("user3", "securepass", "short")); // false
        
        // Test case 5: Another valid reset
        System.out.println(resetPassword("user3", "securepass", "newpassword999")); // true
    }
}
