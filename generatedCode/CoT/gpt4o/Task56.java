package CoT.openai;
import java.security.SecureRandom;
import java.util.Base64;

public class Task56 {

    private static final SecureRandom secureRandom = new SecureRandom();

    public static String generateToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(generateToken());
        }
    }
}