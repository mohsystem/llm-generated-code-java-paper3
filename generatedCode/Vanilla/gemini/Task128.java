package Vanilla.gemini;
import java.util.Random;

class Task128 {
    public static String generateRandomToken(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateRandomToken(10));
        System.out.println(generateRandomToken(5));
        System.out.println(generateRandomToken(15));
        System.out.println(generateRandomToken(8));
        System.out.println(generateRandomToken(12));
    }
}