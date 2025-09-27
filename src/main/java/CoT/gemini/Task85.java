package CoT.gemini;
import java.security.SecureRandom;
import java.util.Random;

class Task85 {
    public static String generateRandomString(int length) {
        if (length <= 0) {
            return "";
        }

        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            sb.append(allowedChars.charAt(randomIndex));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateRandomString(10));
        System.out.println(generateRandomString(5));
        System.out.println(generateRandomString(0));
        System.out.println(generateRandomString(20));
        System.out.println(generateRandomString(15));


    }
}