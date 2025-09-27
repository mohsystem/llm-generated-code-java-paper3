package CoT.codestral;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74 {
    public static Connection createPostgresConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost/test";
            String user = "user";
            String password = "password";

            Connection connection = createPostgresConnection(url, user, password);
            System.out.println("Connected to Postgres database.");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to Postgres database.");
            e.printStackTrace();
        }
    }
}