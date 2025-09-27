package Vanilla.llama31;
import java.security.SecureRandom;

public class Task128 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(generateRandomNumber(0, 100));
        }
    }

    public static int generateRandomNumber(int min, int max) {
        SecureRandom random = new SecureRandom();
        return random.nextInt(max - min + 1) + min;
    }
}