package ZeroShot.gemini;
import java.security.SecureRandom;

public class Task85 {

    public static String generateRandomString(int length) {
        SecureRandom random = new SecureRandom();
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            sb.append(allowedChars.charAt(randomIndex));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateRandomString(10));
        System.out.println(generateRandomString(5));
        System.out.println(generateRandomString(20));
        System.out.println(generateRandomString(15));
        System.out.println(generateRandomString(8));
    }
}