package ZeroShot.gemini;
import java.security.SecureRandom;
import java.util.Base64;

class Task128 {
    public static String generateRandomToken(int length) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[length];
        secureRandom.nextBytes(token);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(token);
    }

    public static void main(String[] args) {
        System.out.println(generateRandomToken(16));
        System.out.println(generateRandomToken(24));
        System.out.println(generateRandomToken(32));
        System.out.println(generateRandomToken(8));
        System.out.println(generateRandomToken(12));
    }
}