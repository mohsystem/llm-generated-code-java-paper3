package CoT.claude;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64;

public class Task135 {
    private static Map<String, String> tokenStore = new HashMap<>();
    private static final SecureRandom secureRandom = new SecureRandom();
    
    public static String generateCSRFToken(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            return null;
        }
        
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);
        String token = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
        
        tokenStore.put(sessionId, token);
        return token;
    }
    
    public static boolean validateCSRFToken(String sessionId, String token) {
        if (sessionId == null || token == null || 
            sessionId.trim().isEmpty() || token.trim().isEmpty()) {
            return false;
        }
        
        String storedToken = tokenStore.get(sessionId);
        if (storedToken == null) {
            return false;
        }
        
        boolean isValid = storedToken.equals(token);
        if (isValid) {
            tokenStore.remove(sessionId); // One-time use token
        }
        return isValid;
    }
    
    public static void main(String[] args) {
        // Test Case 1: Valid token validation
        String sessionId1 = "session123";
        String token1 = generateCSRFToken(sessionId1);
        System.out.println("Test 1: " + validateCSRFToken(sessionId1, token1)); // Should print true
        
        // Test Case 2: Invalid token
        String sessionId2 = "session456";
        String token2 = generateCSRFToken(sessionId2);
        System.out.println("Test 2: " + validateCSRFToken(sessionId2, "invalid_token")); // Should print false
        
        // Test Case 3: Null session ID
        System.out.println("Test 3: " + validateCSRFToken(null, "some_token")); // Should print false
        
        // Test Case 4: Empty token
        String sessionId4 = "session789";
        System.out.println("Test 4: " + validateCSRFToken(sessionId4, "")); // Should print false
        
        // Test Case 5: Reuse token (should fail)
        String sessionId5 = "session101";
        String token5 = generateCSRFToken(sessionId5);
        validateCSRFToken(sessionId5, token5); // First use
        System.out.println("Test 5: " + validateCSRFToken(sessionId5, token5)); // Should print false (second use)
    }
}
