package Vanilla.gpt4o;
import java.util.Random;

public class Task128 {

    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {
        System.out.println("Java Random Numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.println(generateRandomNumber(1, 100));
        }
    }
}