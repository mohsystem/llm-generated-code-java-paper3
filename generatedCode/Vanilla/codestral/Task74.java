package Vanilla.codestral;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74 {
    public static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/test";
        String user = "username";
        String password = "password";
        try {
            Connection conn = createConnection(url, user, password);
            // Use the connection here...
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}