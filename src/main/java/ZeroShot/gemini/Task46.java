package ZeroShot.gemini;
import java.sql.*;
import java.util.Scanner;

public class Task46 {

    private static final String DB_URL = "jdbc:sqlite:users.db"; // Example SQLite DB

    public static void registerUser(String name, String email, String password) {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password); // In a real application, hash the password before storing
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        // Create the table if it doesn't exist (for SQLite)
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            String createTableSql = "CREATE TABLE IF NOT EXISTS users (name TEXT, email TEXT UNIQUE, password TEXT)";
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }



        registerUser("John Doe", "john.doe@example.com", "password123");
        registerUser("Jane Smith", "jane.smith@example.com", "securepass");
        registerUser("Peter Jones", "peter.jones@example.com", "p@$$wOrd");
        registerUser("Alice Brown", "alice.brown@example.com", "al1c3");
        registerUser("Bob Green", "bob.green@example.com", "b0bgR33n");


    }
}