package ZeroShot.claude;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task102 {
    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes());
        
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static boolean updatePassword(String username, String newPassword) {
        String hashedPassword;
        try {
            hashedPassword = hashPassword(newPassword);
        } catch (NoSuchAlgorithmException e) {
            return false;
        }

        String url = "jdbc:mysql://localhost:3306/userdb";
        String dbUser = "dbuser";
        String dbPassword = "dbpass";

        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword)) {
            String sql = "UPDATE users SET password = ? WHERE username = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, hashedPassword);
                pstmt.setString(2, username);
                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(updatePassword("john_doe", "SecurePass123!")); // Test case 1
        System.out.println(updatePassword("jane_smith", "StrongP@ss456")); // Test case 2
        System.out.println(updatePassword("admin", "Admin@2023")); // Test case 3
        System.out.println(updatePassword("test_user", "Test123!")); // Test case 4
        System.out.println(updatePassword("guest", "Guest@2023")); // Test case 5
    }
}
