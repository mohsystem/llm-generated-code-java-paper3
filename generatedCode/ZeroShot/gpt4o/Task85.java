package ZeroShot.openai;
import java.security.SecureRandom;

public class Task85 {
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String generateRandomString(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder result = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(LETTERS.length());
            result.append(LETTERS.charAt(index));
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateRandomString(10));
        System.out.println(generateRandomString(15));
        System.out.println(generateRandomString(5));
        System.out.println(generateRandomString(12));
        System.out.println(generateRandomString(20));
    }
}