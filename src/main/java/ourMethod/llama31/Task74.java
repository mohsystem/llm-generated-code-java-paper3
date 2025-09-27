package ourMethod.llama31;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Java
public class Task74 {
    // ...
    public static void main(String[] args) {
        // Test cases
        testConnection("localhost", "mydatabase", "myuser", "mypassword");
        testConnection("invalid-host", "mydatabase", "myuser", "mypassword");
        testConnection("localhost", "invalid-database", "myuser", "mypassword");
        testConnection("localhost", "mydatabase", "invalid-user", "mypassword");
        testConnection("localhost", "mydatabase", "myuser", "invalid-password");
    }

    public static void testConnection(String host, String database, String user, String password) {
        try (Connection conn = createPostgresConnection(host, user, password)) {
            System.out.println("Connected to the PostgreSQL database!");
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database: " + e.getMessage());
        }
    }
    public static Connection createPostgresConnection(String url, String user, String password) {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error creating connection: " + e.getMessage());
            return null;
        }
    }
}