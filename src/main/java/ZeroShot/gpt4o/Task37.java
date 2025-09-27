package ZeroShot.gpt4o;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task37 {
    public static void main(String[] args) {
        Task37 task = new Task37();
        task.getUserInfo("user1");
        task.getUserInfo("user2");
        task.getUserInfo("user3");
        task.getUserInfo("user4");
        task.getUserInfo("user5");
    }

    public void getUserInfo(String username) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println("User ID: " + resultSet.getInt("id"));
                        System.out.println("Username: " + resultSet.getString("username"));
                        System.out.println("Email: " + resultSet.getString("email"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}