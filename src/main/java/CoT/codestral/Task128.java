package CoT.codestral;
import java.security.SecureRandom;
import java.util.Base64;

public class Task128 {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    public static String generateRandomToken(int length) {
        byte[] randomBytes = new byte[length];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    public static void main(String[] args) {
        System.out.println(generateRandomToken(16));
        System.out.println(generateRandomToken(16));
        System.out.println(generateRandomToken(16));
        System.out.println(generateRandomToken(16));
        System.out.println(generateRandomToken(16));
    }
}