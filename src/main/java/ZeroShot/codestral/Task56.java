package ZeroShot.codestral;
import java.security.SecureRandom;
import java.util.Base64;

public class Task56 {
    public static String generateToken() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[24];
        secureRandom.nextBytes(token);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(token);
    }

    public static void main(String[] args) {
        System.out.println(generateToken());
        System.out.println(generateToken());
        System.out.println(generateToken());
        System.out.println(generateToken());
        System.out.println(generateToken());
    }
}