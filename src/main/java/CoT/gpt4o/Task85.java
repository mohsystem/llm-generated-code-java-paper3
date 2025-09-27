package CoT.gpt4o;
import java.security.SecureRandom;

public class Task85 {

    private static final String ASCII_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String generateRandomString(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ASCII_LETTERS.length());
            sb.append(ASCII_LETTERS.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateRandomString(10));
        System.out.println(generateRandomString(15));
        System.out.println(generateRandomString(20));
        System.out.println(generateRandomString(5));
        System.out.println(generateRandomString(25));
    }
}