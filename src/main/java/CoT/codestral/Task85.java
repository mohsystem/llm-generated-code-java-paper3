package CoT.codestral;
import java.security.SecureRandom;
import java.util.Random;

public class Task85 {
    public static String generateRandomString(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length should be a positive integer");
        }

        StringBuilder sb = new StringBuilder(length);
        Random random = new SecurityManager() != null ? new Random() : new SecureRandom();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateRandomString(10));
        System.out.println(generateRandomString(15));
        System.out.println(generateRandomString(5));
        System.out.println(generateRandomString(20));
        System.out.println(generateRandomString(8));
    }
}