package ZeroShot.llama31;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Task133 {
    private static Map<String, PasswordResetToken> tokens = new HashMap<>();

    public static void main(String[] args) {
        // Test cases
        String userEmail = "user@example.com";
        String token = generatePasswordResetToken(userEmail);
        System.out.println("Password reset token: " + token);
        if (verifyToken(token, "newPassword")) {
            System.out.println("Password reset successful");
        } else {
            System.out.println("Password reset failed");
        }

        // Additional test cases
        System.out.println(generatePasswordResetToken("user2@example.com"));
        System.out.println(verifyToken(token, "newPassword")); // Should fail because token is already used
        System.out.println(verifyToken("invalidToken", "newPassword")); // Should fail because token is invalid
        System.out.println(generatePasswordResetToken("user3@example.com"));
        System.out.println(verifyToken(token, "newPassword")); // Should fail because token is already used
    }

    public static String generatePasswordResetToken(String email) {
        String token = generateSecureToken();
        long expiryTime = System.currentTimeMillis() + 30 * 60 * 1000; // 30 minutes
        PasswordResetToken passwordResetToken = new PasswordResetToken(token, expiryTime);
        tokens.put(token, passwordResetToken);
        return token;
    }

    public static boolean verifyToken(String token, String newPassword) {
        if (!tokens.containsKey(token)) {
            return false;
        }
        PasswordResetToken passwordResetToken = tokens.get(token);
        if (passwordResetToken.expiryTime < System.currentTimeMillis()) {
            return false;
        }
        // Update password here
        tokens.remove(token);
        return true;
    }

    private static String generateSecureToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    private static class PasswordResetToken {
        String token;
        long expiryTime;

        public PasswordResetToken(String token, long expiryTime) {
            this.token = token;
            this.expiryTime = expiryTime;
        }
    }
}