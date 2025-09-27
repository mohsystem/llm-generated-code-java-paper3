package Vanilla.llama31;
import java.util.Random;

public class Task85 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(generateRandomString(10));
        }
    }

    public static String generateRandomString(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}