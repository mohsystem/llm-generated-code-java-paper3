package ourMethod.claude;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Task74 {
    private static final int MIN_PORT = 1;
    private static final int MAX_PORT = 65535;
    private static final int DEFAULT_POSTGRES_PORT = 5432;

    public static Connection createPostgresConnection(String host, int port, String database,
                                                      String username, String password) throws SQLException {
        if (host == null || host.trim().isEmpty()) {
            throw new IllegalArgumentException("Host cannot be null or empty");
        }
        if (database == null || database.trim().isEmpty()) {
            throw new IllegalArgumentException("Database name cannot be null or empty");
        }
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        if (port < MIN_PORT || port > MAX_PORT) {
            throw new IllegalArgumentException("Port must be between " + MIN_PORT + " and " + MAX_PORT);
        }

        String sanitizedHost = host.trim();
        String sanitizedDatabase = database.trim();
        String sanitizedUsername = username.trim();

        if (sanitizedHost.contains("/") || sanitizedHost.contains("\\")
                || sanitizedDatabase.contains("/") || sanitizedDatabase.contains("\\")) {
            throw new IllegalArgumentException("Invalid characters in host or database name");
        }

        String url = String.format("jdbc:postgresql://%s:%d/%s",
                sanitizedHost, port, sanitizedDatabase);

        Properties props = new Properties();
        props.setProperty("user", sanitizedUsername);
        props.setProperty("password", password);
        props.setProperty("ssl", "true");
        props.setProperty("sslmode", "verify-full");
        props.setProperty("connectTimeout", "10");

        return DriverManager.getConnection(url, props);
    }

    public static void main(String[] args) {
        System.out.println("Test 1: Valid connection parameters");
        try {
            Connection conn = createPostgresConnection(
                    System.getenv("DB_HOST") != null ? System.getenv("DB_HOST") : "localhost",
                    DEFAULT_POSTGRES_PORT,
                    System.getenv("DB_NAME") != null ? System.getenv("DB_NAME") : "testdb",
                    System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "testuser",
                    System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "testpass"
            );
            System.out.println("Connection created successfully (will fail without real DB)");
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("Expected: " + e.getClass().getSimpleName());
        }

        System.out.println("\nTest 2: Null host");
        try {
            createPostgresConnection(null, DEFAULT_POSTGRES_PORT, "testdb", "user", "pass");
            System.out.println("FAIL: Should throw exception");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("FAIL: Wrong exception type");
        }

        System.out.println("\nTest 3: Invalid port");
        try {
            createPostgresConnection("localhost", 99999, "testdb", "user", "pass");
            System.out.println("FAIL: Should throw exception");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("FAIL: Wrong exception type");
        }

        System.out.println("\nTest 4: Empty database name");
        try {
            createPostgresConnection("localhost", DEFAULT_POSTGRES_PORT, "", "user", "pass");
            System.out.println("FAIL: Should throw exception");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("FAIL: Wrong exception type");
        }

        System.out.println("\nTest 5: Null password");
        try {
            createPostgresConnection("localhost", DEFAULT_POSTGRES_PORT, "testdb", "user", null);
            System.out.println("FAIL: Should throw exception");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("FAIL: Wrong exception type");
        }
    }
}
