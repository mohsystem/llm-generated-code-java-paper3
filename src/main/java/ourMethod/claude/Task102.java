package ourMethod.claude;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

public class Task102 {
    // Method to hash password with salt using SHA-256
    private static String hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }
    
    // Method to generate random salt
    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    // Method to update password in database
    public static boolean updatePassword(String username, String newPassword, Connection conn) {
        if (username == null || username.trim().isEmpty() || 
            newPassword == null || newPassword.trim().isEmpty()) {
            return false;
        }
        
        try {
            // Generate salt
            byte[] salt = generateSalt();
            
            // Hash password with salt
            String hashedPassword = hashPassword(newPassword, salt);
            String saltStr = Base64.getEncoder().encodeToString(salt);
            
            // Update database using prepared statement to prevent SQL injection
            String sql = "UPDATE users SET password_hash = ?, salt = ? WHERE username = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, hashedPassword);
                pstmt.setString(2, saltStr);
                pstmt.setString(3, username);
                int rows = pstmt.executeUpdate();
                return rows > 0;
            }
        } catch (NoSuchAlgorithmException | SQLException e) {
            // Log error properly in production code
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        try {
            // Simulated database connection - replace with actual DB connection in production
            Connection conn = null; 
            
            // Test case 1: Valid username and password
            System.out.println(updatePassword("user1", "StrongPass123!", conn));
            
            // Test case 2: Empty username
            System.out.println(updatePassword("", "password123", conn));
            
            // Test case 3: Null password 
            System.out.println(updatePassword("user2", null, conn));
            
            // Test case 4: Very long password
            System.out.println(updatePassword("user3", "VeryLongPassword".repeat(100), conn));
            
            // Test case 5: Special characters
            System.out.println(updatePassword("user4", "Pass@123$%^", conn));
            
        } catch (Exception e) {
            System.err.println("Error in password update: " + e.getMessage());
        }
    }
}
