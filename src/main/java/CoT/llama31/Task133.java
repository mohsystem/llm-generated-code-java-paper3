package CoT.llama31;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Task133 {
    private static Map<String, Map<String, Object>> users = new HashMap<>();
    private static Map<String, Map<String, Object>> resetTokens = new HashMap<>();

    public static void main(String[] args) {
        // Test cases
        registerUser("user1@example.com", "password123");
        registerUser("user2@example.com", "password456");
        requestPasswordReset("user1@example.com");
        requestPasswordReset("user2@example.com");
        resetPassword("user1@example.com", "newPassword123", "token");
        resetPassword("user2@example.com", "newPassword456", "token");
    }

    public static void registerUser(String email, String password) {
        Map<String, Object> userData = new HashMap<>();
        userData.put("password", hashPassword(password));
        users.put(email, userData);
    }

    public static void requestPasswordReset(String email) {
        if (users.containsKey(email)) {
            String token = generateResetToken();
            Map<String, Object> tokenData = new HashMap<>();
            tokenData.put("email", email);
            tokenData.put("expiry", System.currentTimeMillis() + 3600000); // 1 hour
            resetTokens.put(token, tokenData);
            System.out.println("Password reset token sent: " + token);
        } else {
            System.out.println("User not found.");
        }
    }

    public static void resetPassword(String email, String newPassword, String token) {
        if (resetTokens.containsKey(token)) {
            Map<String, Object> tokenData = resetTokens.get(token);
            if (tokenData.get("email").equals(email) && (long) tokenData.get("expiry") > System.currentTimeMillis()) {
                users.get(email).put("password", hashPassword(newPassword));
                resetTokens.remove(token);
                System.out.println("Password reset successfully.");
            } else {
                System.out.println("Token has expired or is invalid.");
            }
        } else {
            System.out.println("Token not found.");
        }
    }

    private static String generateResetToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[64];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            return Base64.getUrlEncoder().withoutPadding().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}