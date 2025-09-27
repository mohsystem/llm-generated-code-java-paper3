package CoT.gemini;
import java.sql.*;
import java.util.Scanner;

public class Task37 {

    public static ResultSet getUserInfo(String username, Connection connection) throws SQLException {
        // Prepared statement to prevent SQL injection
        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            return preparedStatement.executeQuery();
        }
    }


    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/your_database_name"; // Replace with your database credentials
        String dbUser = "your_username";
        String dbPassword = "your_password";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter username: ");
            String inputUsername = scanner.next();

            ResultSet resultSet = getUserInfo(inputUsername, connection);

            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("id"));
                System.out.println("Username: " + resultSet.getString("username"));
                // Retrieve other user information similarly
            }


            // Test cases
            getUserInfo("testuser1", connection);
            getUserInfo("testuser2", connection);
            getUserInfo("admin", connection);
            getUserInfo("user123", connection);
            getUserInfo("test", connection);



        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}