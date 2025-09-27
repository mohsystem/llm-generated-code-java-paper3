package ZeroShot.gpt4o;
// Java code: Task40.java
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Task40 {

    private static Map<String, String> csrfTokens = new HashMap<>();

    public static String generateCsrfToken(String sessionId) {
        String token = UUID.randomUUID().toString();
        csrfTokens.put(sessionId, token);
        return token;
    }

    public static boolean validateCsrfToken(String sessionId, String token) {
        return token != null && token.equals(csrfTokens.get(sessionId));
    }

    public static String updateUserSettings(String sessionId, String token, String newSettings) {
        if (validateCsrfToken(sessionId, token)) {
            // Simulate updating user settings
            return "Settings updated to: " + newSettings;
        } else {
            return "CSRF Token validation failed.";
        }
    }

    public static void main(String[] args) {
        String sessionId = "session123";
        String validToken = generateCsrfToken(sessionId);
        String invalidToken = "invalidToken";

        System.out.println(updateUserSettings(sessionId, validToken, "New Settings 1")); // Should succeed
        System.out.println(updateUserSettings(sessionId, invalidToken, "New Settings 2")); // Should fail
        System.out.println(updateUserSettings("wrongSession", validToken, "New Settings 3")); // Should fail
        System.out.println(updateUserSettings(sessionId, null, "New Settings 4")); // Should fail
        System.out.println(updateUserSettings(sessionId, validToken, "New Settings 5")); // Should succeed
    }
}