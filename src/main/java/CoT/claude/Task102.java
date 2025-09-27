package CoT.claude;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class Task102 {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}$";
    
    public static boolean updatePassword(String username, String newPassword) {
        if (username == null || username.trim().isEmpty() || newPassword == null) {
            return false;
        }

        // Validate password strength
        if (!Pattern.matches(PASSWORD_PATTERN, newPassword)) {
            return false;
        }

        try {
            // Hash password using SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(newPassword.getBytes());
            
            // Convert byte array to hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedPassword) {
                hexString.append(String.format("%02x", b));
            }
            
            // Update password in database using prepared statement
            String sql = "UPDATE users SET password = ? WHERE username = ?";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, hexString.toString());
                pstmt.setString(2, username);
                
                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            }
            
        } catch (NoSuchAlgorithmException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test 1: " + updatePassword("john_doe", "Password123@")); // Valid
        System.out.println("Test 2: " + updatePassword("jane_doe", "weak")); // Invalid - too short
        System.out.println("Test 3: " + updatePassword("", "Password123@")); // Invalid - empty username
        System.out.println("Test 4: " + updatePassword("bob", "NoSpecialChar1")); // Invalid - no special char
        System.out.println("Test 5: " + updatePassword("alice", "Pass word@1")); // Invalid - contains space
    }

    private static class DatabaseConnection {
        public static Connection getConnection() {
            return null;
        }
    }
}
