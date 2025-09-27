package Vanilla.codestral;
import java.security.SecureRandom;
import java.util.Base64;

public class Task135 {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    public static String generateCSRFToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    // To verify the token, you'd typically store it in a session and compare it to the one received in the request.
}