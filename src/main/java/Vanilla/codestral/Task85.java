package Vanilla.codestral;
import java.util.Random;

public class Task85 {
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateRandomString(5));
        System.out.println(generateRandomString(10));
        System.out.println(generateRandomString(15));
        System.out.println(generateRandomString(20));
        System.out.println(generateRandomString(25));
    }
}