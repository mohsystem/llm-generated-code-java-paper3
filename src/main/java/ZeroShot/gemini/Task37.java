package ZeroShot.gemini;
import java.sql.*;
import java.util.Scanner;

public class Task37 {

    public static ResultSet getUserInfo(String username, Connection connection) throws SQLException {
        // Prepared statement to prevent SQL injection
        String query = "SELECT * FROM users WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);

        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }


    public static void main(String[] args) {
        // Replace with your database credentials
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String user = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter username: ");
            String inputUsername = scanner.nextLine();

            ResultSet resultSet = getUserInfo(inputUsername, connection);


            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("id"));
                System.out.println("Username: " + resultSet.getString("username"));
                // Retrieve other user information...
            }


        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}