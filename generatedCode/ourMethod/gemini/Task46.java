package ourMethod.gemini;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Task46 {

    private static final String DB_URL = "jdbc:sqlite:users.db"; // Securely store DB credentials

    public static void registerUser(String name, String email, String password) {
        // Problem understanding: Collect user data, validate, hash password, store in DB.
        // Security requirements: Prevent SQL injection, hash passwords.

        // Validate input (CWE-20, CWE-23, CWE-79, CWE-89, etc.)
        if (!isValidInput(name, email, password)) {
            System.out.println("Invalid input. Registration failed.");
            return;
        }


        String hashedPassword = hashPassword(password); // Hash password (CWE-256, CWE-257, CWE-327, CWE-759, CWE-916)

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users(name, email, password) VALUES(?, ?, ?)")) {

            // Use parameterized queries to prevent SQL injection (CWE-89)
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, hashedPassword);
            pstmt.executeUpdate();

            System.out.println("User registered successfully.");

        } catch (SQLException e) {
            System.err.println("Error registering user: " + e.getMessage()); // Avoid CWE-209
        }
    }


    private static boolean isValidInput(String name, String email, String password) {
        // Basic input validation. Enhance as needed.
        return name != null && !name.isEmpty() &&
               email != null && !email.isEmpty() && isValidEmail(email) &&
               password != null && !password.isEmpty() && isValidPassword(password);
    }

    private static boolean isValidEmail(String email) {
    	// Basic email validation
    	return email.matches("^[A-Za-z0-9+_.-]+@(.+)$"); // Enhance as needed
    }
    
    private static boolean isValidPassword(String password) {
    	// Basic password validation - at least 8 chars, one uppercase, one lowercase, one digit
    	return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$"); // Enhance as needed
    }
    

    private static String hashPassword(String password) {
        // In a real application, use a strong hashing algorithm like bcrypt or Argon2.
        // This is a placeholder for demonstration purposes only.
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static void main(String[] args) {
        // Test cases
        registerUser("John Doe", "john.doe@example.com", "SecureP@sswOrd1");
        registerUser("Jane Smith", "jane.smith@example.com", "P@$$wOrd2");
        registerUser("", "invalid.email", "weak"); // Invalid input
        registerUser("User3", "user3@example.com", "AnotherSecureP@sswOrd3");
        registerUser("User4", null, "P@$$wOrd4"); // Invalid input
    }
}