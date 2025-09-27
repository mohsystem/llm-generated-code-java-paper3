package Vanilla.claude;

import java.sql.*;

public class Task37 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";
    
    public static String getUserInfo(String username) {
        String result = "";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM users WHERE username = ?");
            stmt.setString(1, username);
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                result = "ID: " + rs.getInt("id") + 
                         ", Username: " + rs.getString("username") +
                         ", Email: " + rs.getString("email");
            } else {
                result = "User not found";
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException e) {
            result = "Database error: " + e.getMessage();
        }
        return result;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(getUserInfo("john_doe"));
        System.out.println(getUserInfo("jane_smith"));
        System.out.println(getUserInfo("admin"));
        System.out.println(getUserInfo("test_user"));
        System.out.println(getUserInfo("nonexistent"));
    }
}
