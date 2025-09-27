package ZeroShot.codestral;
import java.security.SecureRandom;

public class Task128 {
    public static int generateRandomNumber(int bound) {
        SecureRandom random = new SecureRandom();
        return random.nextInt(bound);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(generateRandomNumber(100));
        }
    }
}