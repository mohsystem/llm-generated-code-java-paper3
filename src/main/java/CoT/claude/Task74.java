package CoT.claude;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74 {
    public static Connection getConnection(String host, String dbName, String user, String password) {
        Connection conn = null;
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
            
            // Create connection URL with parameters
            String url = String.format("jdbc:postgresql://%s:5432/%s", host, dbName);
            
            // Get connection with credentials
            conn = DriverManager.getConnection(url, user, password);
            
            if (conn != null) {
                return conn;
            }
            
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection failed.");
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        // Test cases
        String host = "localhost";
        String dbName = "testdb";
        String user = "postgres";
        String password = "password123";

        // Test case 1: Valid connection parameters
        Connection conn1 = getConnection(host, dbName, user, password);
        System.out.println("Test 1: " + (conn1 != null ? "Connection successful" : "Connection failed"));

        // Test case 2: Invalid host
        Connection conn2 = getConnection("invalidhost", dbName, user, password);
        System.out.println("Test 2: " + (conn2 != null ? "Connection successful" : "Connection failed"));

        // Test case 3: Invalid database name
        Connection conn3 = getConnection(host, "invaliddb", user, password);
        System.out.println("Test 3: " + (conn3 != null ? "Connection successful" : "Connection failed"));

        // Test case 4: Invalid username
        Connection conn4 = getConnection(host, dbName, "invaliduser", password);
        System.out.println("Test 4: " + (conn4 != null ? "Connection successful" : "Connection failed"));

        // Test case 5: Invalid password
        Connection conn5 = getConnection(host, dbName, user, "invalidpass");
        System.out.println("Test 5: " + (conn5 != null ? "Connection successful" : "Connection failed"));
    }
}
