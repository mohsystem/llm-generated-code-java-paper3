package ourMethod.llama31;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Task42 {
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        // Test cases
        registerUser("user1", "password123");
        registerUser("user2", "password456");

        System.out.println(authenticateUser("user1", "password123")); // true
        System.out.println(authenticateUser("user1", "wrongpassword")); // false
        System.out.println(authenticateUser("user2", "password456")); // true
    }

    public static void registerUser(String username, String password) {
        try {
            // Hash the password using SHA-256
            String hashedPassword = hashPassword(password);
            users.put(username, hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error hashing password: " + e.getMessage());
        }
    }

    public static boolean authenticateUser(String username, String password) {
        if (!users.containsKey(username)) {
            return false;
        }
        try {
            // Hash the provided password and compare it with the stored hash
            String providedHash = hashPassword(password);
            return users.get(username).equals(providedHash);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error hashing password: " + e.getMessage());
            return false;
        }
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hashBytes);
    }
}