package ourMethod.llama31;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task133 {
    public static void main(String[] args) {
        // Test cases
        String userEmail = "user@example.com";
        String newPassword = "NewPassword123!";
        resetPassword(userEmail, newPassword);
    }

    public static void resetPassword(String userEmail, String newPassword) {
        // Generate a secure token
        String token = generateToken();

        // Store the token in the database
        storeTokenInDatabase(userEmail, token);

        // Send the token to the user via email
        sendTokenViaEmail(userEmail, token);

        // Verify the token and update the password
        verifyTokenAndResetPassword(userEmail, token, newPassword);
    }

    public static String generateToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[64];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    public static void storeTokenInDatabase(String userEmail, String token) {
        try (Connection conn = DriverManager.getConnection("jdbc:yourdburl", "username", "password")) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO password_reset_tokens (user_id, token, token_expiry) VALUES (?, ?, ?)");
            stmt.setString(1, userEmail);
            stmt.setString(2, token);
            stmt.setLong(3, System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error storing token: " + e.getMessage());
        }
    }

    public static void sendTokenViaEmail(String userEmail, String token) {
        // Simulate sending an email
        System.out.println("Sending token to " + userEmail + ": " + token);
    }

    public static void verifyTokenAndResetPassword(String userEmail, String token, String newPassword) {
        try (Connection conn = DriverManager.getConnection("jdbc:yourdburl", "username", "password")) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM password_reset_tokens WHERE user_id = ? AND token = ?");
            stmt.setString(1, userEmail);
            stmt.setString(2, token);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() && rs.getLong("token_expiry") > System.currentTimeMillis()) {
                // Update the password
                stmt = conn.prepareStatement("UPDATE users SET password = ? WHERE email = ?");
                stmt.setString(1, hashPassword(newPassword));
                stmt.setString(2, userEmail);
                stmt.executeUpdate();
                System.out.println("Password reset successfully.");
            } else {
                System.out.println("Invalid or expired token.");
            }
        } catch (SQLException e) {
            System.err.println("Error verifying token: " + e.getMessage());
        }
    }

    public static String hashPassword(String password) {
        // Simple hashing example, use a secure hashing algorithm in production
        return UUID.nameUUIDFromBytes(password.getBytes()).toString();
    }
}