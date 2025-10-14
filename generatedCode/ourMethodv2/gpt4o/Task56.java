package ourMethodv2.gpt4o;
import java.security.SecureRandom;
import java.util.Base64;

public class Task56 {

    public static String generateToken(int length) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[length];
        secureRandom.nextBytes(tokenBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
    }

    public static void main(String[] args) {
        System.out.println(generateToken(32));
        System.out.println(generateToken(32));
        System.out.println(generateToken(32));
        System.out.println(generateToken(32));
        System.out.println(generateToken(32));
    }
}