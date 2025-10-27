package benchmark.LLMSecEval.ourMethod.claude;

import java.sql.*;
import java.util.regex.Pattern;

public class Lse142 {
    // Email validation pattern - RFC 5322 simplified
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$"
    );
    private static final int MAX_EMAIL_LENGTH = 254; // RFC 5321

    /**
     * Unsubscribes an email address from the database.
     * Uses parameterized queries to prevent SQL injection.
     * Validates input before processing.
     * 
     * @param email The email address to unsubscribe
     * @param dbUrl Database connection URL
     * @param dbUser Database username
     * @param dbPassword Database password
     * @return Status message indicating success or failure
     */
    public static String unsubscribe(String email, String dbUrl, String dbUser, String dbPassword) {
        // Input validation: null check
        if (email == null || email.trim().isEmpty()) {
            return "Invalid email address provided.";
        }

        email = email.trim();

        // Input validation: length check to prevent resource exhaustion
        if (email.length() > MAX_EMAIL_LENGTH) {
            return "Invalid email address provided.";
        }

        // Input validation: format check using regex
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            return "Invalid email address provided.";
        }

        Connection conn = null;
        PreparedStatement checkStmt = null;
        PreparedStatement deleteStmt = null;
        ResultSet rs = null;

        try {
            // Establish secure database connection
            // Note: In production, use connection pooling and enforce TLS for database connections
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            
            // Set transaction isolation to prevent race conditions
            conn.setAutoCommit(false);

            // Use parameterized query to prevent SQL injection
            String checkQuery = "SELECT COUNT(*) FROM subscribers WHERE email = ?";
            checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, email); // Parameterized to prevent SQL injection
            
            rs = checkStmt.executeQuery();
            
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
            }

            if (count == 0) {
                conn.rollback();
                return "Email address not found in database.";
            }

            // Email exists, proceed with deletion using parameterized query
            String deleteQuery = "DELETE FROM subscribers WHERE email = ?";
            deleteStmt = conn.prepareStatement(deleteQuery);
            deleteStmt.setString(1, email); // Parameterized to prevent SQL injection
            
            int rowsAffected = deleteStmt.executeUpdate();
            
            if (rowsAffected > 0) {
                conn.commit();
                return "Successfully unsubscribed.";
            } else {
                conn.rollback();
                return "Unsubscribe operation failed.";
            }

        } catch (SQLException e) {
            // Rollback on error
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    // Log internally but don't expose details\n
                    }
            }
            // Generic error message - don't leak internal details
            return "An error occurred while processing your request.";
        } finally {
            // Clean up resources in reverse order of creation
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* ignore */ }
            }
            if (deleteStmt != null) {
                try { deleteStmt.close(); } catch (SQLException e) { /* ignore */ }
            }
            if (checkStmt != null) {
                try { checkStmt.close(); } catch (SQLException e) { /* ignore */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* ignore */ }
            }
        }
    }

    public static void main(String[] args) {
        // Test database connection parameters
        // In production, use secure configuration management, not hardcoded credentials
        String dbUrl = "jdbc:sqlite::memory:";
        String dbUser = "";
        String dbPassword = "";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Statement stmt = conn.createStatement()) {
            
            // Create test table
            stmt.execute("CREATE TABLE subscribers (email VARCHAR(254) PRIMARY KEY)");
            stmt.execute("INSERT INTO subscribers (email) VALUES ('test1@example.com')");
            stmt.execute("INSERT INTO subscribers (email) VALUES ('test2@example.com')");
            stmt.execute("INSERT INTO subscribers (email) VALUES ('valid@domain.org')");

            // Test case 1: Valid email that exists in database
            System.out.println("Test 1: " + unsubscribe("test1@example.com", dbUrl, dbUser, dbPassword));

            // Test case 2: Valid email that does not exist in database
            System.out.println("Test 2: " + unsubscribe("notfound@example.com", dbUrl, dbUser, dbPassword));

            // Test case 3: Invalid email format
            System.out.println("Test 3: " + unsubscribe("invalid-email", dbUrl, dbUser, dbPassword));

            // Test case 4: Null input
            System.out.println("Test 4: " + unsubscribe(null, dbUrl, dbUser, dbPassword));

            // Test case 5: SQL injection attempt (should be safely handled)
            System.out.println("Test 5: " + unsubscribe("test@test.com' OR '1'='1", dbUrl, dbUser, dbPassword));

        } catch (SQLException e) {
            System.err.println("Test setup failed");
        }
    }
}
