package ourMethod.claude;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74 {
    public static Connection getConnection(String host, String port, String database, String username, String password) throws SQLException {
        if (host == null || port == null || database == null || username == null || password == null) {
            throw new IllegalArgumentException("Connection parameters cannot be null");
        }

        String url = String.format("jdbc:postgresql://%s:%s/%s", host, port, database);
        
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL JDBC Driver not found", e);
        }
    }

    public static void main(String[] args) {
        try {
            // Test case 1 - Valid connection
            Connection conn1 = getConnection("localhost", "5432", "testdb", "user", "password");
            System.out.println("Test 1: Connection successful");
            conn1.close();

            // Test case 2 - Invalid host
            Connection conn2 = getConnection("invalidhost", "5432", "testdb", "user", "password");
            conn2.close();

            // Test case 3 - Invalid port
            Connection conn3 = getConnection("localhost", "1234", "testdb", "user", "password");
            conn3.close();

            // Test case 4 - Invalid credentials
            Connection conn4 = getConnection("localhost", "5432", "testdb", "invalid", "invalid");
            conn4.close();

            // Test case 5 - Null parameters
            Connection conn5 = getConnection(null, "5432", "testdb", "user", "password");
            conn5.close();

        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }
}
