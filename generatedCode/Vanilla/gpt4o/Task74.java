package Vanilla.gpt4o;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74 {
    public static Connection createPostgresConnection(String url, String user, String password) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/testdb";
        String user = "user";
        String password = "password";
        
        // Test cases
        Connection conn1 = createPostgresConnection(url, user, password);
        System.out.println(conn1 != null ? "Connection successful" : "Connection failed");

        Connection conn2 = createPostgresConnection("invalid_url", user, password);
        System.out.println(conn2 != null ? "Connection successful" : "Connection failed");

        Connection conn3 = createPostgresConnection(url, "wrong_user", password);
        System.out.println(conn3 != null ? "Connection successful" : "Connection failed");

        Connection conn4 = createPostgresConnection(url, user, "wrong_password");
        System.out.println(conn4 != null ? "Connection successful" : "Connection failed");

        Connection conn5 = createPostgresConnection(url, user, password);
        System.out.println(conn5 != null ? "Connection successful" : "Connection failed");
    }
}