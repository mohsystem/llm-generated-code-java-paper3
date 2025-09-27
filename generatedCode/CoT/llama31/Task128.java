package CoT.llama31;
import java.util.Random;

public class Task128 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(generateRandomNumber(100));
            System.out.println(generateRandomToken(10));
        }
    }

    public static int generateRandomNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    public static String generateRandomToken(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder token = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            token.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return token.toString();
    }
}