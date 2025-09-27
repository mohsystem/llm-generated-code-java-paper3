package CoT.gpt4o;
import java.security.SecureRandom;

public class Task128 {
    public static String generateRandomToken(int length) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder token = new StringBuilder(length);
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < length; i++) {
            int index = secureRandom.nextInt(chars.length());
            token.append(chars.charAt(index));
        }

        return token.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateRandomToken(10));
        System.out.println(generateRandomToken(15));
        System.out.println(generateRandomToken(20));
        System.out.println(generateRandomToken(25));
        System.out.println(generateRandomToken(30));
    }
}