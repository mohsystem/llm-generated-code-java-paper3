package CoT.gemini;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class Task128 {

    public static String generateRandomNumber(int length) {
        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String generateRandomToken(int length) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bytes = new byte[length];
        secureRandom.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    public static void main(String[] args) {
        System.out.println("Test case 1: " + generateRandomNumber(10));
        System.out.println("Test case 2: " + generateRandomToken(16));
        System.out.println("Test case 3: " + generateRandomNumber(5));
        System.out.println("Test case 4: " + generateRandomToken(24));
        System.out.println("Test case 5: " + generateRandomNumber(12));

    }
}