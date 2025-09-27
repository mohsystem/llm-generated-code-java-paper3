package ourMethod.codestral;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74 {
    public static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/test";
        String user = "postgres";
        String password = "password";
        try {
            Connection conn = createConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}