package CoT.llama31;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74 {
    public static Connection createPostgresConnection(String url, String user, String password) {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error creating connection: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/testdb";
        String user = "postgres";
        String password = "cohondob";

        // Test cases
        for (int i = 0; i < 5; i++) {
            Connection conn = createPostgresConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connection created successfully");
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}