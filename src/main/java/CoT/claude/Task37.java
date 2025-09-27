package CoT.claude;

import java.sql.*;

public class Task37 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "testuser";
    private static final String PASS = "testpass";

    public static String getUserInfo(String username) {
        StringBuilder result = new StringBuilder();
        
        // Input validation
        if (username == null || username.trim().isEmpty()) {
            return "Invalid username";
        }
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            // Using prepared statement to prevent SQL injection
            String sql = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        result.append("User ID: ").append(rs.getInt("id"))
                              .append(", Name: ").append(rs.getString("name"))
                              .append(", Email: ").append(rs.getString("email"));
                    } else {
                        result.append("User not found");
                    }
                }
            }
        } catch (SQLException e) {
            return "Database error: " + e.getMessage();
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(getUserInfo("john_doe"));
        System.out.println(getUserInfo("alice123"));
        System.out.println(getUserInfo("")); // Empty username
        System.out.println(getUserInfo("admin'--")); // SQL injection attempt
        System.out.println(getUserInfo("nonexistent_user"));
    }
}
