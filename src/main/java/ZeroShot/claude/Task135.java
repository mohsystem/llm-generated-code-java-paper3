package ZeroShot.claude;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class Task135 {
    private static final int TOKEN_LENGTH = 32;
    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static Map<String, String> tokenStore = new HashMap<>();
    private static SecureRandom random = new SecureRandom();

    public static String generateToken(String sessionId) {
        StringBuilder token = new StringBuilder(TOKEN_LENGTH);
        for (int i = 0; i < TOKEN_LENGTH; i++) {
            token.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        String csrfToken = token.toString();
        tokenStore.put(sessionId, csrfToken);
        return csrfToken;
    }

    public static boolean validateToken(String sessionId, String token) {
        if (sessionId == null || token == null) {
            return false;
        }
        String storedToken = tokenStore.get(sessionId);
        if (storedToken == null) {
            return false;
        }
        return storedToken.equals(token);
    }

    public static void main(String[] args) {
        // Test case 1: Generate and validate valid token
        String sessionId1 = "session123";
        String token1 = generateToken(sessionId1);
        System.out.println("Test 1: " + validateToken(sessionId1, token1)); // Should print true

        // Test case 2: Invalid token
        System.out.println("Test 2: " + validateToken(sessionId1, "wrongtoken")); // Should print false

        // Test case 3: Invalid session ID
        System.out.println("Test 3: " + validateToken("wrongsession", token1)); // Should print false

        // Test case 4: Null values
        System.out.println("Test 4: " + validateToken(null, token1)); // Should print false
        
        // Test case 5: Generate new token for same session
        String newToken = generateToken(sessionId1);
        System.out.println("Test 5: " + validateToken(sessionId1, token1)); // Should print false as token was updated
    }
}
