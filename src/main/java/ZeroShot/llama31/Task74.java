package ZeroShot.llama31;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74 {
    public static Connection createPostgresConnection(String url, String user, String password) {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/mydb";
        String user = "myuser";
        String password = "mypassword";

        Connection conn = createPostgresConnection(url, user, password);
        if (conn != null) {
            System.out.println("Connected to PostgreSQL database");
        } else {
            System.out.println("Failed to connect to PostgreSQL database");
        }
    }
}