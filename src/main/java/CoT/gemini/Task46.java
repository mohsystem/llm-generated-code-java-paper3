package CoT.gemini;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Task46 {

    public static void registerUser(String name, String email, String password) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:users.db"); // Example SQLite connection
            String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql); // Use PreparedStatement to prevent SQL injection
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password); // In real app, hash the password before storing
            statement.executeUpdate();
            connection.close();
            System.out.println("User registered successfully.");
        } catch (SQLException e) {
            System.err.println("Error registering user: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        // Test cases
        registerUser("Test User 1", "test1@example.com", "password123");
        registerUser("Test User 2", "test2@example.com", "securepass");
        registerUser("John Doe", "john.doe@example.com", "john's password"); // Example with potentially problematic input
        registerUser("Jane Doe", "jane.doe@example.com", "P@$$wOrd");
        registerUser("<script>alert('XSS')</script>", "xss@example.com", "<script>malicious</script>"); // Example with XSS attempt



    }
}