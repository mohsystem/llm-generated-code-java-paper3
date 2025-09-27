package ourMethod.llama31;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Task37 {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";
        String tableName = "users";

        try (Connection conn = DriverManager.getConnection(dbUrl, user, password)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the username:");
            String username = scanner.nextLine();

            String query = "SELECT * FROM " + tableName + " WHERE username = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("User found:");
                        System.out.println("Username: " + rs.getString("username"));
                        System.out.println("Name: " + rs.getString("name"));
                        System.out.println("Email: " + rs.getString("email"));
                    } else {
                        System.out.println("User not found");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}