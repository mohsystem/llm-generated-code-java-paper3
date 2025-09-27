package CoT.claude;

import java.sql.*;
import java.util.regex.Pattern;

public class Task46 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "password";

    public static boolean registerUser(String name, String email, String password) {
        // Input validation
        if (!isValidInput(name, email, password)) {
            return false;
        }

        // Hash password before storing
        String hashedPassword = hashPassword(password);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
                String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, sanitizeInput(name));
                    pstmt.setString(2, sanitizeInput(email));
                    pstmt.setString(3, hashedPassword);
                    pstmt.executeUpdate();
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    private static boolean isValidInput(String name, String email, String password) {
        if (name == null || email == null || password == null) {
            return false;
        }
        
        // Email validation using regex
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!Pattern.matches(emailRegex, email)) {
            return false;
        }
        
        // Password strength check
        if (password.length() < 8) {
            return false;
        }
        
        return true;
    }

    private static String sanitizeInput(String input) {
        return input.replaceAll("[^a-zA-Z0-9@._-]", "");
    }

    private static String hashPassword(String password) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(registerUser("John Doe", "john@example.com", "password123")); // Valid input
        System.out.println(registerUser(null, "email@test.com", "pass123")); // Invalid input - null name
        System.out.println(registerUser("Jane", "invalid-email", "pass123")); // Invalid email format
        System.out.println(registerUser("Bob", "bob@test.com", "123")); // Password too short
        System.out.println(registerUser("Alice", "alice@example.com", "securePass123")); // Valid input
    }
}
