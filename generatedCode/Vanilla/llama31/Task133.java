package Vanilla.llama31;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Task133 {
    private static Map<String, PasswordResetToken> tokens = new HashMap<>();

    public static void main(String[] args) {
        testPasswordReset();
    }

    public static void testPasswordReset() {
        String email = "user@example.com";
        String newPassword = "newpassword";

        String token = generatePasswordResetToken(email);
        sendPasswordResetEmail(email, token);

        if (verifyPasswordResetToken(token, newPassword)) {
            System.out.println("Password reset successfully.");
        } else {
            System.out.println("Password reset failed.");
        }
    }

    public static String generatePasswordResetToken(String email) {
        String token = generateRandomToken();
        long expiry = Instant.now().plus(30, ChronoUnit.MINUTES).getEpochSecond();
        tokens.put(token, new PasswordResetToken(email, expiry));
        return token;
    }

    public static void sendPasswordResetEmail(String email, String token) {
        System.out.println("Sending password reset email to " + email + " with token " + token);
    }

    public static boolean verifyPasswordResetToken(String token, String newPassword) {
        if (!tokens.containsKey(token)) {
            return false;
        }

        PasswordResetToken resetToken = tokens.get(token);
        if (Instant.now().getEpochSecond() > resetToken.expiry) {
            return false;
        }

        // Update password logic here
        System.out.println("Updating password for " + resetToken.email);
        tokens.remove(token);
        return true;
    }

    private static String generateRandomToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[64];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    private static class PasswordResetToken {
        String email;
        long expiry;

        public PasswordResetToken(String email, long expiry) {
            this.email = email;
            this.expiry = expiry;
        }
    }
}