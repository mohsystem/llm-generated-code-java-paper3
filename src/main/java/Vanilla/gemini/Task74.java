package Vanilla.gemini;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74 {

    public static Connection getPostgresConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        try {
            // Replace with your PostgreSQL database credentials
            String url = "jdbc:postgresql://localhost:5432/your_database_name";
            String user = "your_username";
            String password = "your_password";

            Connection conn1 = getPostgresConnection(url, user, password);
            if (conn1 != null) System.out.println("Test 1: Connection successful!");
            conn1.close();


            Connection conn2 = getPostgresConnection(url, user, password);
            if (conn2 != null) System.out.println("Test 2: Connection successful!");
            conn2.close();

            Connection conn3 = getPostgresConnection(url, user, password);
            if (conn3 != null) System.out.println("Test 3: Connection successful!");
            conn3.close();

            Connection conn4 = getPostgresConnection(url, user, password);
            if (conn4 != null) System.out.println("Test 4: Connection successful!");
            conn4.close();

            Connection conn5 = getPostgresConnection(url, user, password);
            if (conn5 != null) System.out.println("Test 5: Connection successful!");
            conn5.close();


        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }
}