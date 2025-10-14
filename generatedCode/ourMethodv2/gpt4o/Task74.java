package ourMethodv2.gpt4o;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task74 {

    public static Connection createPostgresConnection(String url, String user, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static void main(String[] args) {
        try {
            Connection conn1 = createPostgresConnection("jdbc:postgresql://localhost:5432/mydb1", "user1", "pass1");
            System.out.println("Connection 1 established: " + (conn1 != null));

            Connection conn2 = createPostgresConnection("jdbc:postgresql://localhost:5432/mydb2", "user2", "pass2");
            System.out.println("Connection 2 established: " + (conn2 != null));

            Connection conn3 = createPostgresConnection("jdbc:postgresql://localhost:5432/mydb3", "user3", "pass3");
            System.out.println("Connection 3 established: " + (conn3 != null));

            Connection conn4 = createPostgresConnection("jdbc:postgresql://localhost:5432/mydb4", "user4", "pass4");
            System.out.println("Connection 4 established: " + (conn4 != null));

            Connection conn5 = createPostgresConnection("jdbc:postgresql://localhost:5432/mydb5", "user5", "pass5");
            System.out.println("Connection 5 established: " + (conn5 != null));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}