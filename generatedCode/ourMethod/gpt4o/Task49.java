package ourMethod.gpt4o;
import java.sql.*;
import java.util.Properties;

public class Task49 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        try {
            createUser("John Doe", "john.doe@example.com");
            createUser("Jane Smith", "jane.smith@example.com");
            createUser("Alice Johnson", "alice.johnson@example.com");
            createUser("Bob Brown", "bob.brown@example.com");
            createUser("Charlie White", "charlie.white@example.com");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createUser(String name, String email) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Properties properties = new Properties();
            properties.setProperty("user", DB_USER);
            properties.setProperty("password", DB_PASSWORD);
            connection = DriverManager.getConnection(DB_URL, properties);

            String query = "INSERT INTO users (name, email) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}