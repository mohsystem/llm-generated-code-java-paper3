package ourMethod.codestral;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

public class Task85 {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Random RANDOM = new SecureRandom();

    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(randomString(10));
        System.out.println(randomString(20));
        System.out.println(randomString(30));
        System.out.println(randomString(40));
        System.out.println(randomString(50));
    }
}