package ourMethod.openai;
import java.security.SecureRandom;

public class Task128 {
    private SecureRandom secureRandom;

    public Task128() {
        secureRandom = new SecureRandom();
    }

    public int generateRandomNumber(int min, int max) {
        return secureRandom.nextInt((max - min) + 1) + min;
    }

    public String generateRandomToken(int length) {
        StringBuilder token = new StringBuilder(length);
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < length; i++) {
            token.append(characters.charAt(secureRandom.nextInt(characters.length())));
        }
        return token.toString();
    }

    public static void main(String[] args) {
        Task128 task = new Task128();

        // Test cases
        System.out.println(task.generateRandomNumber(1, 100)); // Random number between 1 and 100
        System.out.println(task.generateRandomToken(10)); // Random token of length 10
        System.out.println(task.generateRandomNumber(1, 50)); // Random number between 1 and 50
        System.out.println(task.generateRandomToken(15)); // Random token of length 15
        System.out.println(task.generateRandomNumber(10, 20)); // Random number between 10 and 20
    }
}