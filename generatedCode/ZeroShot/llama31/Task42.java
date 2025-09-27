package ZeroShot.llama31;
import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class Task42 {
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        // Test cases
        registerUser("user1", "password123");
        registerUser("user2", "password456");
        System.out.println(loginUser("user1", "password123")); // true
        System.out.println(loginUser("user1", "wrongpassword")); // false
        System.out.println(loginUser("user2", "password456")); // true
        System.out.println(loginUser("nonexistent", "password")); // false
    }

    public static void registerUser(String username, String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hashedPassword = new StringBuilder();
            for (byte b : hashedBytes) {
                hashedPassword.append(String.format("%02x", b));
            }
            users.put(username, hashedPassword.toString());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static boolean loginUser(String username, String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hashedPassword = new StringBuilder();
            for (byte b : hashedBytes) {
                hashedPassword.append(String.format("%02x", b));
            }
            return users.getOrDefault(username, "").equals(hashedPassword.toString());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }
}