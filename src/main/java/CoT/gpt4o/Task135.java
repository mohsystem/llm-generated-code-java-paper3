package CoT.gpt4o;
import java.util.HashMap;
import java.util.UUID;

public class Task135 {
    private static HashMap<String, String> sessionTokens = new HashMap<>();

    public static String generateToken(String sessionId) {
        String token = UUID.randomUUID().toString();
        sessionTokens.put(sessionId, token);
        return token;
    }

    public static boolean verifyToken(String sessionId, String token) {
        return token != null && token.equals(sessionTokens.get(sessionId));
    }

    public static void main(String[] args) {
        // Test cases
        String sessionId1 = "session1";
        String sessionId2 = "session2";

        String token1 = generateToken(sessionId1);
        String token2 = generateToken(sessionId2);

        System.out.println(verifyToken(sessionId1, token1)); // Expected: true
        System.out.println(verifyToken(sessionId1, "wrongToken")); // Expected: false
        System.out.println(verifyToken(sessionId2, token2)); // Expected: true
        System.out.println(verifyToken(sessionId2, token1)); // Expected: false
        System.out.println(verifyToken("invalidSession", token1)); // Expected: false
    }
}