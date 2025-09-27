package ZeroShot.codestral;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74 {
    public static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        try {
            Connection conn = createConnection("jdbc:postgresql://hostname/dbname", "username", "password");
            // use the connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}