package ZeroShot.claude;

import java.util.*;
import java.sql.*;

public class Task46 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "password";
    
    public static boolean registerUser(String name, String email, String password) {
        if (!validateInput(name, email, password)) {
            return false;
        }
        
        String hashedPassword = hashPassword(password);
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email); 
            stmt.setString(3, hashedPassword);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }
    
    private static boolean validateInput(String name, String email, String password) {
        if (name == null || name.trim().isEmpty() || name.length() > 50) {
            return false;
        }
        
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            return false;
        }
        
        if (password == null || password.length() < 8 || !password.matches(".*[A-Z].*") || 
            !password.matches(".*[a-z].*") || !password.matches(".*[0-9].*")) {
            return false;
        }
        
        return true;
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
        System.out.println(registerUser("John Doe", "john@example.com", "Password123")); // Valid input
        System.out.println(registerUser("", "invalid", "weak")); // Invalid input
        System.out.println(registerUser("Jane Doe", "jane@example.com", "StrongPass1")); // Valid input
        System.out.println(registerUser("Test User", "notanemail", "Pass123")); // Invalid email
        System.out.println(registerUser("Long Name User", "test@example.com", "nodigits")); // Invalid password
    }
}
