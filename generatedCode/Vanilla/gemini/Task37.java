package Vanilla.gemini;
import java.sql.*;
import java.util.Scanner;

public class Task37 {

    public static ResultSet getUserInfo(String username, Connection connection) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?"; // Replace "users" with your actual table name
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        return statement.executeQuery();
    }


    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database_name"; // Replace with your database URL
        String user = "your_username"; // Replace with your database username
        String password = "your_password"; // Replace with your database password

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Scanner scanner = new Scanner(System.in);

            String[] testUsernames = {"testuser1", "testuser2", "testuser3", "testuser4", "testuser5"};
            for (String testUsername : testUsernames) {
                ResultSet resultSet = getUserInfo(testUsername, connection);
                while (resultSet.next()) {
                    System.out.println("Username: " + resultSet.getString("username"));
                    // Add other columns to retrieve here
                }
            }


        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}