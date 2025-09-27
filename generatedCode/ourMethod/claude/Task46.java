package ourMethod.claude;

import java.sql.*;
import java.util.regex.Pattern;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class Task46 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String DB_USER = "user";
    private static final String DB_PASS = "password";
    
    public static boolean registerUser(String name, String email, String password) {
        // Input validation
        if (!isValidInput(name, email, password)) {
            return false;
        }

        try {
            // Generate salt and hash password
            byte[] salt = generateSalt();
            String hashedPassword = hashPassword(password, salt);
            
            // Store in database using prepared statement
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
                String sql = "INSERT INTO users (name, email, password_hash, salt) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, name);
                    stmt.setString(2, email); 
                    stmt.setString(3, hashedPassword);
                    stmt.setBytes(4, salt);
                    stmt.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException e) {
            // Log error and return false
            System.err.println("Database error: " + e.getMessage());
            return false;
        }
    }

    private static boolean isValidInput(String name, String email, String password) {
        // Validate name - only letters, numbers, spaces, min 2 chars, max 50 chars
        if (name == null || !Pattern.matches("^[a-zA-Z0-9\\\\s]{2,50}$", name)) {
            return false;
        }

        // Validate email format
        if (email == null || !Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email)) {
            return false;
        }

        // Validate password - min 8 chars, must contain digit, lower, upper, special char
        if (password == null || !Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}$", password)) {
            return false;
        }

        return true;
    }

    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    private static String hashPassword(String password, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(registerUser("John Doe", "john@example.com", "Password123#")); // Valid
        System.out.println(registerUser("A", "invalid-email", "short")); // Invalid - fails validation
        System.out.println(registerUser("Jane Doe", "jane@example.com", "Password456$")); // Valid  
        System.out.println(registerUser(null, "null@example.com", "Password789!")); // Invalid - null name
        System.out.println(registerUser("<script>alert(1)</script>", "hack@test.com", "Hacker123$")); // Invalid - fails validation
    }
}
