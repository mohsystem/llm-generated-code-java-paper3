package ourMethod.gemini;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

public class Task128 {

    public static String generateRandomNumber(int length) {
        if (length <= 0) {
            return ""; 
        }

        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }


    public static String generateRandomToken() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println("Test case 1: " + generateRandomNumber(5));
        System.out.println("Test case 2: " + generateRandomNumber(10));
        System.out.println("Test case 3: " + generateRandomNumber(0));
        System.out.println("Test case 4: " + generateRandomToken());
        System.out.println("Test case 5: " + generateRandomToken());
    }
}