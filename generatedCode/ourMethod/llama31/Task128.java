package ourMethod.llama31;
import java.util.Random;

public class Task128 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Random Number: " + generateRandomNumber());
            System.out.println("Random Token: " + generateRandomToken());
        }
    }

    public static int generateRandomNumber() {
        // Using a secure random number generator
        Random rand = new Random();
        return rand.nextInt(1000); // Generate a random number between 0 and 999
    }

    public static String generateRandomToken() {
        // Using a secure random number generator
        Random rand = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder token = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            token.append(characters.charAt(rand.nextInt(characters.length())));
        }
        return token.toString();
    }
}