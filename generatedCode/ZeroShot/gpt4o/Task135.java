package ZeroShot.gpt4o;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Task135 {

    private static Map<String, String> csrfTokens = new HashMap<>();

    public static String generateCsrfToken(String sessionId) {
        String token = UUID.randomUUID().toString();
        csrfTokens.put(sessionId, token);
        return token;
    }

    public static boolean verifyCsrfToken(String sessionId, String token) {
        if (csrfTokens.containsKey(sessionId)) {
            return csrfTokens.get(sessionId).equals(token);
        }
        return false;
    }

    public static void main(String[] args) {
        String sessionId1 = "session1";
        String sessionId2 = "session2";
        String sessionId3 = "session3";
        String sessionId4 = "session4";
        String sessionId5 = "session5";

        String token1 = generateCsrfToken(sessionId1);
        String token2 = generateCsrfToken(sessionId2);
        String token3 = generateCsrfToken(sessionId3);
        String token4 = generateCsrfToken(sessionId4);
        String token5 = generateCsrfToken(sessionId5);

        System.out.println(verifyCsrfToken(sessionId1, token1)); // true
        System.out.println(verifyCsrfToken(sessionId2, token2)); // true
        System.out.println(verifyCsrfToken(sessionId3, token3)); // true
        System.out.println(verifyCsrfToken(sessionId4, "fake_token")); // false
        System.out.println(verifyCsrfToken("invalid_session", token5)); // false
    }
}