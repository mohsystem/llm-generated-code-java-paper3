package CoT.llama31;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Task46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        // Hash the password before storing
        String hashedPassword = hashPassword(password);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user-registration", "root", "")) {
            String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, hashedPassword);
                stmt.executeUpdate();
                System.out.println("User registered successfully");
            }
        } catch (SQLException e) {
            System.out.println("Error registering user: " + e.getMessage());
        }
    }

    // Simplified password hashing for demonstration purposes
    private static String hashPassword(String password) {
        // In a real application, use a secure hashing algorithm like bcrypt or PBKDF2
        return password; // Replace with actual hashing logic
    }
}