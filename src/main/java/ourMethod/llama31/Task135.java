package ourMethod.llama31;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Task135 {
    private static Map<String, String> csrfTokens = new HashMap<>();
    private static SecureRandom random = new SecureRandom();

    public static String generateCSRFToken() {
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        String token = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
        csrfTokens.put(token, token);
        return token;
    }

    public static boolean validateCSRFToken(String token) {
        return csrfTokens.containsKey(token);
    }

    public static void main(String[] args) {
        // Generate and validate tokens
        String token = generateCSRFToken();
        System.out.println("Generated Token: " + token);
        System.out.println("Token Valid: " + validateCSRFToken(token));

        // Test cases
        System.out.println("Token Valid (invalid token): " + validateCSRFToken("invalid-token"));
        System.out.println("Token Valid (null token): " + validateCSRFToken(null));

        // Generate and validate multiple tokens
        String token2 = generateCSRFToken();
        System.out.println("Generated Token 2: " + token2);
        System.out.println("Token 2 Valid: " + validateCSRFToken(token2));
        System.out.println("Token 1 Valid after generating token 2: " + validateCSRFToken(token));
    }
}