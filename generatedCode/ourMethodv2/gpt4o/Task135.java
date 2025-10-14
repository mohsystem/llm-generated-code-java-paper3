package ourMethodv2.gpt4o;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Task135 {

    private static Map<String, String> csrfTokens = new HashMap<>();

    // Generate a new CSRF token for a session
    public static String generateCsrfToken(String sessionId) {
        String token = UUID.randomUUID().toString();
        csrfTokens.put(sessionId, token);
        return token;
    }

    // Validate CSRF token
    public static boolean validateCsrfToken(String sessionId, String token) {
        String validToken = csrfTokens.get(sessionId);
        return validToken != null && validToken.equals(token);
    }

    public static void main(String[] args) {
        // Test cases
        String sessionId1 = "session1";
        String token1 = generateCsrfToken(sessionId1);
        System.out.println(validateCsrfToken(sessionId1, token1)); // true

        String sessionId2 = "session2";
        String token2 = generateCsrfToken(sessionId2);
        System.out.println(validateCsrfToken(sessionId2, token2)); // true

        System.out.println(validateCsrfToken(sessionId1, token2)); // false
        System.out.println(validateCsrfToken(sessionId2, token1)); // false

        String fakeToken = "fakeToken";
        System.out.println(validateCsrfToken(sessionId1, fakeToken)); // false
    }
}