package Vanilla.codestral;
import java.util.Random;

public class Task128 {
    public static int generateRandomNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    public static void main(String[] args) {
        System.out.println(generateRandomNumber(100)); // Test case
    }
}