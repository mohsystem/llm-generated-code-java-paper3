package ourMethod.gpt4o;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class Task135 {
    private static Map<String, String> userSessions = new HashMap<>();
    private static Map<String, String> csrfTokens = new HashMap<>();

    public static String login(String username) {
        String sessionId = UUID.randomUUID().toString();
        String csrfToken = UUID.randomUUID().toString();
        userSessions.put(username, sessionId);
        csrfTokens.put(sessionId, csrfToken);
        return sessionId;
    }

    public static String getCsrfToken(String sessionId) {
        return csrfTokens.get(sessionId);
    }

    public static boolean validateRequest(String sessionId, String csrfToken) {
        return csrfTokens.get(sessionId) != null && csrfTokens.get(sessionId).equals(csrfToken);
    }

    public static void main(String[] args) {
        String session1 = login("user1");
        String token1 = getCsrfToken(session1);
        System.out.println(validateRequest(session1, token1)); // true

        String session2 = login("user2");
        String token2 = getCsrfToken(session2);
        System.out.println(validateRequest(session2, token2)); // true

        // Invalid CSRF token
        System.out.println(validateRequest(session1, "invalidToken")); // false

        // Reusing token for another session
        System.out.println(validateRequest(session2, token1)); // false

        // Invalid session ID
        System.out.println(validateRequest("invalidSession", token1)); // false
    }
}