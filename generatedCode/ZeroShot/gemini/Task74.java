package ZeroShot.gemini;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74 {

    public static Connection getPostgresConnection(String url, String user, String password) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL JDBC driver not found.", e);
        }
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/your_database_name"; // Replace with your database URL
        String user = "your_username"; // Replace with your username
        String password = "your_password"; // Replace with your password


        try {
            Connection conn1 = getPostgresConnection(url, user, password);
            if (conn1 != null) {
                System.out.println("Test 1: Connection successful");
                conn1.close();
            }

             conn1 = getPostgresConnection(url, user, password);
            if (conn1 != null) {
                System.out.println("Test 2: Connection successful");
                conn1.close();
            }
           
             conn1 = getPostgresConnection(url, user, password);
            if (conn1 != null) {
                System.out.println("Test 3: Connection successful");
                conn1.close();
            }
           
             conn1 = getPostgresConnection(url, user, password);
            if (conn1 != null) {
                System.out.println("Test 4: Connection successful");
                conn1.close();
            }
            
            conn1 = getPostgresConnection(url, user, password);
            if (conn1 != null) {
                System.out.println("Test 5: Connection successful");
                conn1.close();
            }


        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}