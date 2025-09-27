package ZeroShot.llama31;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Task37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the username:");
        String username = scanner.nextLine();

        String url = "jdbc:mysql://localhost:3306/your_database"; // Replace with your database URL
        String user = "your_username"; // Replace with your database username
        String password = "your_password"; // Replace with your database password

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?")) {

            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("User ID: " + rs.getInt("id"));
                    System.out.println("Username: " + rs.getString("username"));
                    System.out.println("Name: " + rs.getString("name"));
                    // Add other fields as necessary
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}