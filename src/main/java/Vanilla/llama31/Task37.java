package Vanilla.llama31;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task37 {
    public static void main(String[] args) {
        String dbUrl = "jdbc:sqlserver://your_server;databaseName=your_database";
        String user = "your_username";
        String password = "your_password";
        String[] usernames = {"user1", "user2", "user3", "user4", "user5"};

        try (Connection conn = DriverManager.getConnection(dbUrl, user, password)) {
            for (String username : usernames) {
                getUserInfo(conn, username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getUserInfo(Connection conn, String username) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("Username: " + rs.getString("username"));
                    System.out.println("Full Name: " + rs.getString("full_name"));
                    System.out.println("Email: " + rs.getString("email"));
                    // Add other fields as needed
                }
            }
        }
    }
}