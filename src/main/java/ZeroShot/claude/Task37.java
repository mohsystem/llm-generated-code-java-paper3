package ZeroShot.claude;

import java.sql.*;

public class Task37 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String USER = "dbuser";
    private static final String PASS = "dbpass";
    
    public static String getUserInfo(String username) {
        String result = "";
        
        // Input validation
        if (username == null || !username.matches("^[a-zA-Z0-9_]{3,20}$")) {
            return "Invalid username format";
        }
        
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Use prepared statement to prevent SQL injection
            String sql = "SELECT id, username, email FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                result = "ID: " + rs.getInt("id") + 
                        ", Username: " + rs.getString("username") + 
                        ", Email: " + rs.getString("email");
            } else {
                result = "User not found";
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            result = "Database error: " + e.getMessage();
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(getUserInfo("john_doe"));
        System.out.println(getUserInfo("alice123"));
        System.out.println(getUserInfo("admin"));
        System.out.println(getUserInfo("'; DROP TABLE users;--")); // SQL injection attempt
        System.out.println(getUserInfo("")); // Invalid input
    }
}
