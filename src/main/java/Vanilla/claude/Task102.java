package Vanilla.claude;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task102 {
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes());
        
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static boolean updatePassword(String username, String newPassword) {
        String url = "jdbc:mysql://localhost:3306/userdb";
        String dbUser = "root";
        String dbPassword = "password";
        
        try {
            String hashedPassword = hashPassword(newPassword);
            Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
            String sql = "UPDATE users SET password = ? WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, hashedPassword);
            pstmt.setString(2, username);
            int rowsAffected = pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[][] testCases = {
            {"john_doe", "newPass123"},
            {"jane_smith", "securePass456"},
            {"admin", "adminPass789"},
            {"user1", "userPass321"},
            {"test_user", "testPass654"}
        };

        for (String[] test : testCases) {
            boolean result = updatePassword(test[0], test[1]);
            System.out.println("Update password for " + test[0] + ": " + 
                             (result ? "Success" : "Failed"));
        }
    }
}
