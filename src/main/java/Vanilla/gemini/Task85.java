package Vanilla.gemini;
import java.security.SecureRandom;
import java.util.Random;

class Task85 {
    public static String generateRandomString(int length) {
        if (length <= 0) {
            return "";
        }

        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomInt = random.nextInt(52); // 26 uppercase + 26 lowercase letters
            char randomChar = (char) (randomInt < 26 ? 'A' + randomInt : 'a' + (randomInt - 26));
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateRandomString(5));
        System.out.println(generateRandomString(10));
        System.out.println(generateRandomString(0));
        System.out.println(generateRandomString(1));
        System.out.println(generateRandomString(20));
    }
}