package Vanilla.gpt4o;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class Task135 {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Map<String, String> sessionTokens = new HashMap<>();

    public static String generateCSRFToken(String sessionId) {
        byte[] tokenBytes = new byte[16];
        secureRandom.nextBytes(tokenBytes);
        StringBuilder token = new StringBuilder();
        for (byte b : tokenBytes) {
            token.append(String.format("%02x", b));
        }
        sessionTokens.put(sessionId, token.toString());
        return token.toString();
    }

    public static boolean validateCSRFToken(String sessionId, String csrfToken) {
        return csrfToken.equals(sessionTokens.get(sessionId));
    }

    public static void main(String[] args) {
        String session1 = "session1";
        String session2 = "session2";
        String session3 = "session3";
        String session4 = "session4";
        String session5 = "session5";

        String token1 = generateCSRFToken(session1);
        String token2 = generateCSRFToken(session2);
        String token3 = generateCSRFToken(session3);
        String token4 = generateCSRFToken(session4);
        String token5 = generateCSRFToken(session5);

        System.out.println(validateCSRFToken(session1, token1)); // true
        System.out.println(validateCSRFToken(session2, token2)); // true
        System.out.println(validateCSRFToken(session3, "wrongtoken")); // false
        System.out.println(validateCSRFToken(session4, token4)); // true
        System.out.println(validateCSRFToken(session5, token1)); // false
    }
}