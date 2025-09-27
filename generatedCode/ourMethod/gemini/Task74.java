package ourMethod.gemini;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74 {

    public static Connection getPostgresConnection(String url, String user, String password) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL Driver not found", e);
        }


        Connection connection = DriverManager.getConnection(url, user, password);
        if (connection == null) {
          throw new SQLException("Failed to create connection");
        }
        return connection;

    }

    public static void main(String[] args) {
        String testUrl = "jdbc:postgresql://localhost:5432/testdb";
        String testUser = "testuser";
        String testPassword = "testpassword";


        try {
            Connection conn1 = getPostgresConnection(testUrl, testUser, testPassword);
            System.out.println("Connection 1 successful: " + (conn1 != null));
            conn1.close();


            Connection conn2 = getPostgresConnection(testUrl, "wronguser", testPassword);
            System.out.println("Connection 2 successful: " + (conn2 != null));
            conn2.close();

        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }



        try {
             Connection conn3 = getPostgresConnection(testUrl, testUser, "wrongpassword");
            System.out.println("Connection 3 successful: " + (conn3 != null));
            conn3.close();


        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }

        try {
            Connection conn4 = getPostgresConnection("jdbc:postgresql://invalidhost:5432/testdb", testUser, testPassword);
            System.out.println("Connection 4 successful: " + (conn4 != null));
            conn4.close();

        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }

        try {
             Connection conn5 = getPostgresConnection(testUrl, testUser, testPassword);
            System.out.println("Connection 5 successful: " + (conn5 != null));
             if (conn5 != null) {
              System.out.println("isValid: " + conn5.isValid(10));
             }
            conn5.close();
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }


    }
}