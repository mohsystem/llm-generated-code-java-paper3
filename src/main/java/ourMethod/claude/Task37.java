package ourMethod.claude;

import java.sql.*;
import java.util.Scanner;

public class Task37 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String DB_USER = "dbuser";
    private static final String DB_PASSWORD = "dbpassword";
    
    public static void getUserInfo(String username) {
        if (username == null || username.trim().isEmpty()) {
            System.out.println("Username cannot be empty");
            return;
        }
        
        // Use try-with-resources to ensure proper resource cleanup
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Use PreparedStatement to prevent SQL injection
            String query = "SELECT id, username, email FROM users WHERE username = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, username);
                
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        // Safely handle and display results
                        System.out.println("User found:");
                        System.out.println("ID: " + rs.getInt("id"));
                        System.out.println("Username: " + rs.getString("username"));
                        System.out.println("Email: " + rs.getString("email"));
                    } else {
                        System.out.println("User not found");
                    }
                }
            }
        } catch (SQLException e) {
            // Log the error securely, avoid exposing sensitive details
            System.out.println("Error occurred while accessing database");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter username to search: ");
            String username = scanner.nextLine();
            getUserInfo(username);
        }
        
        // Test cases
        System.out.println("\\nTest Cases:");
        getUserInfo("validUser");
        getUserInfo(""); // Empty username
        getUserInfo(null); // Null username
        getUserInfo("user'; DROP TABLE users; --"); // SQL injection attempt
        getUserInfo("normalUser123");
    }
}
