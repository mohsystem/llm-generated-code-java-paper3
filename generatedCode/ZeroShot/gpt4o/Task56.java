package ZeroShot.openai;
import java.security.SecureRandom;
import java.util.Base64;

public class Task56 {

    public static String generateToken() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[32];
        secureRandom.nextBytes(token);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(token);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Generated Token: " + generateToken());
        }
    }
}