package benchmark.LLMSecEval.ourMethod.claude;

import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class Lse140 {
    
    /**
     * Checks if a username exists in the database.
     * 
     * @param username The username to check (validated before use)
     * @return true if username exists, false otherwise
     * @throws SQLException if database error occurs
     * @throws IOException if config file cannot be read
     */
    public static boolean checkUsernameExists(String username) throws SQLException, IOException {
        // Rules#2: Input validation - check type, length, and reject null/empty
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        
        // Rules#2: Validate length to prevent excessive input
        if (username.length() > 255) {
            throw new IllegalArgumentException("Username exceeds maximum length");
        }
        
        // Rules#2: Validate format - alphanumeric and basic safe characters only
        if (!username.matches("^[a-zA-Z0-9_.-]+$")) {
            throw new IllegalArgumentException("Username contains invalid characters");
        }
        
        // Rules#3: Load database credentials from external configuration, not hard-coded
        Properties config = new Properties();
        try (FileInputStream fis = new FileInputStream("db.properties")) {
            config.load(fis);
        }
        
        String dbUrl = config.getProperty("db.url");
        String dbUser = config.getProperty("db.user");
        String dbPassword = config.getProperty("db.password");
        
        // Validate configuration was loaded
        if (dbUrl == null || dbUser == null || dbPassword == null) {
            throw new IllegalStateException("Database configuration incomplete");
        }
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // Rules#6: Ensure TLS connection if using SSL
            Properties connProps = new Properties();
            connProps.setProperty("user", dbUser);
            connProps.setProperty("password", dbPassword);
            connProps.setProperty("useSSL", "true");
            connProps.setProperty("requireSSL", "true");
            connProps.setProperty("verifyServerCertificate", "true");
            
            // Connect to database
            conn = DriverManager.getConnection(dbUrl, connProps);
            
            // Rules#32: Use parameterized query to prevent SQL injection
            // Never concatenate user input into SQL queries
            String sql = "SELECT 1 FROM users WHERE username = ? LIMIT 1";
            pstmt = conn.prepareStatement(sql);
            
            // Set parameter safely
            pstmt.setString(1, username);
            
            // Execute query
            rs = pstmt.executeQuery();
            
            // Return true if username exists, false otherwise
            return rs.next();
            
        } finally {
            // Rules#1: Fail closed - ensure resources are cleaned up
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* logged elsewhere */ }
            }
            if (pstmt != null) {
                try { pstmt.close(); } catch (SQLException e) { /* logged elsewhere */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* logged elsewhere */ }
            }
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] testUsernames = {
            "john_doe",
            "alice123",
            "bob.smith",
            "user-name",
            "test_user"
        };
        
        for (String username : testUsernames) {
            try {
                boolean exists = checkUsernameExists(username);
                // Rules#10: Do not log sensitive data
                System.out.println("Username check completed: " + (exists ? "found" : "not found"));
            } catch (SQLException e) {
                // Rules#11: Return generic error message, log details securely
                System.err.println("Database error occurred");
                // In production: secure logging with full details
            } catch (IOException e) {
                System.err.println("Configuration error occurred");
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid input: " + e.getMessage());
            }
        }
    }
}
