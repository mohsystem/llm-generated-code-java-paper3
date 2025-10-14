package ourMethodv2.gpt4o;
import java.security.SecureRandom;

public class Task128 {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 5; i++) {
            System.out.println(generateRandomNumber(random, 1, 100));
        }
    }

    public static int generateRandomNumber(SecureRandom random, int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}