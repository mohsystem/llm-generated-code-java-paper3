package ZeroShot.gemini;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

class Task84 {
    public static String generateSessionId() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[24]; // 192 bits for session ID
        secureRandom.nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }


    public static void main(String[] args) {
        System.out.println(generateSessionId());
        System.out.println(generateSessionId());
        System.out.println(generateSessionId());
        System.out.println(generateSessionId());
        System.out.println(generateSessionId());

    }
}