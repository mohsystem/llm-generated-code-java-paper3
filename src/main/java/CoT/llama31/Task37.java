package CoT.llama31;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task37 {
    public static void main(String[] args) {
        // Test cases
        String[] usernames = {"user1", "user2", "user3", "user4", "user5"};
        for (String username : usernames) {
            getUserInfo(username);
        }
    }

    public static void getUserInfo(String username) {
        String dbUrl = "jdbc:mysql://localhost:3306/yourdb";
        String dbUser = "youruser";
        String dbPassword = "yourpassword";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?")) {

            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("User ID: " + rs.getInt("id"));
                    System.out.println("Username: " + rs.getString("username"));
                    System.out.println("Name: " + rs.getString("name"));
                    // Add more fields as needed
                } else {
                    System.out.println("User not found: " + username);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}