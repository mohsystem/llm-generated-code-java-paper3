package ourMethod.llama31;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class Task46 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/users";
    private static final String USER = "root";
    private static final String PASS = "";

    public static void main(String[] args) {
        // Test cases
        registerUser("John Doe", "john.doe@example.com", "password123");
        registerUser("Jane Doe", "jane.doe@example.com", "password456");
    }

    public static void registerUser(String name, String email, String password) {
        // Validate input
        if (!isValidName(name) || !isValidEmail(email) || !isValidPassword(password)) {
            System.out.println("Invalid input");
            return;
        }

        // Hash the password
        String hashedPassword = hashPassword(password);

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO userdata (username, email, password) VALUES (?, ?, ?)")) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, hashedPassword);

            if (stmt.executeUpdate() > 0) {
                System.out.println("User registered successfully");
            } else {
                System.out.println("Registration failed");
            }
        } catch (SQLException e) {
            System.out.println("Error registering user: " + e.getMessage());
        }
    }

    private static boolean isValidName(String name) {
        return name != null && name.length() > 0;
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        return email != null && Pattern.matches(emailRegex, email, Pattern.CASE_INSENSITIVE);
    }

    private static boolean isValidPassword(String password) {
        return password != null && password.length() >= 8;
    }

    private static String hashPassword(String password) {
        // Use a secure hashing algorithm like BCrypt or PBKDF2
        // For simplicity, using a basic hash here
        return org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
    }
}