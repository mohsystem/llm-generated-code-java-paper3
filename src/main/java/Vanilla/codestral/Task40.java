package Vanilla.codestral;
// Java: Generating and validating CSRF tokens
import java.security.SecureRandom;
import java.util.Base64;

public class Task40 {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    public static String generateCSRFToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    public static boolean isCSRFTokenValid(String existingToken, String receivedToken) {
        return existingToken.equals(receivedToken);
    }
}