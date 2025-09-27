package ourMethod.gpt4o;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74 {

    public static Connection getPostgresConnection(String url, String user, String password) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return connection;
    }

    public static void main(String[] args) {
        // Test cases
        String url = "jdbc:postgresql://localhost/testdb";
        String user = "testuser";
        String password = "testpassword";
        try {
            Connection conn = getPostgresConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connection established.");
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to establish connection.");
        }
    }
}