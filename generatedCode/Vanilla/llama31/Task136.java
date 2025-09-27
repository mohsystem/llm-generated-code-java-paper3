package Vanilla.llama31;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class Task136 {
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean authenticate(String username, String password, String storedHash) {
        String hashedPassword = hashPassword(password);
        return hashedPassword.equals(storedHash);
    }

    public static void main(String[] args) {
        String username = "testuser";
        String password = "testpassword";
        String storedHash = hashPassword(password);

        // Test cases
        System.out.println("Authentication result for correct credentials: " + authenticate(username, password, storedHash));
        System.out.println("Authentication result for incorrect password: " + authenticate(username, "wrongpassword", storedHash));
        System.out.println("Authentication result for incorrect username: " + authenticate("wronguser", password, storedHash));
        System.out.println("Authentication result for empty password: " + authenticate(username, "", storedHash));
        System.out.println("Authentication result for empty username: " + authenticate("", password, storedHash));
    }
}