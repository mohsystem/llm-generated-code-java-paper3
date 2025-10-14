package CoT.openai;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74 {

    public static Connection getPostgresConnection(String url, String user, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/mydatabase";
        String user = "myuser";
        String password = "mypassword";

        // Test cases
        Connection conn1 = getPostgresConnection(url, user, password);
        Connection conn2 = getPostgresConnection(url, "wronguser", password);
        Connection conn3 = getPostgresConnection(url, user, "wrongpassword");
        Connection conn4 = getPostgresConnection("jdbc:postgresql://wronghost:5432/mydatabase", user, password);
        Connection conn5 = getPostgresConnection(url, user, password);

        System.out.println(conn1 != null ? "Connected" : "Failed");
        System.out.println(conn2 != null ? "Connected" : "Failed");
        System.out.println(conn3 != null ? "Connected" : "Failed");
        System.out.println(conn4 != null ? "Connected" : "Failed");
        System.out.println(conn5 != null ? "Connected" : "Failed");
    }
}