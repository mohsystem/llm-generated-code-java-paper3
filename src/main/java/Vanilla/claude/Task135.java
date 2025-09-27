package Vanilla.claude;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Task135 {
    private static final Map<String, String> csrfTokenStore = new HashMap<>();
    private static final SecureRandom secureRandom = new SecureRandom();
    
    public static String generateCSRFToken(String sessionId) {
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);
        String token = Base64.getEncoder().encodeToString(randomBytes);
        csrfTokenStore.put(sessionId, token);
        return token;
    }
    
    public static boolean validateCSRFToken(String sessionId, String token) {
        String storedToken = csrfTokenStore.get(sessionId);
        if (storedToken == null) return false;
        return storedToken.equals(token);
    }
    
    public static void main(String[] args) {
        // Test case 1: Generate and validate valid token
        String sessionId1 = "session1";
        String token1 = generateCSRFToken(sessionId1);
        System.out.println("Test 1: " + validateCSRFToken(sessionId1, token1)); // Should print true
        
        // Test case 2: Invalid token
        System.out.println("Test 2: " + validateCSRFToken(sessionId1, "invalid_token")); // Should print false
        
        // Test case 3: Invalid session
        System.out.println("Test 3: " + validateCSRFToken("invalid_session", token1)); // Should print false
        
        // Test case 4: Multiple tokens for different sessions
        String sessionId2 = "session2";
        String token2 = generateCSRFToken(sessionId2);
        System.out.println("Test 4: " + validateCSRFToken(sessionId2, token2)); // Should print true
        
        // Test case 5: Token replacement
        String newToken = generateCSRFToken(sessionId1);
        System.out.println("Test 5: " + validateCSRFToken(sessionId1, token1)); // Should print false
    }
}
