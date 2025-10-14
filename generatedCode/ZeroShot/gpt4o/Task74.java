package ZeroShot.openai;
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
        String url = "jdbc:postgresql://localhost:5432/testdb";
        String user = "testuser";
        String password = "testpassword";

        for (int i = 0; i < 5; i++) {
            try {
                Connection connection = getPostgresConnection(url, user, password);
                System.out.println("Connection " + (i + 1) + ": " + (connection != null ? "Successful" : "Failed"));
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Connection " + (i + 1) + ": Failed");
            }
        }
    }
}