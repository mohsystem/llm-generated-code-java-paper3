package ZeroShot.codestral;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task85 {
    private static final SecureRandom random = new SecureRandom();
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String generateRandomString(int length) {
        return IntStream.range(0, length)
                .mapToObj(i -> ALPHABET.charAt(random.nextInt(ALPHABET.length())))
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(generateRandomString(10));
        System.out.println(generateRandomString(15));
        System.out.println(generateRandomString(20));
        System.out.println(generateRandomString(25));
        System.out.println(generateRandomString(30));
    }
}