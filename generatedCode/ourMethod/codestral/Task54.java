package ourMethod.codestral;
import java.util.Random;

public class Task54 {
    private static final int PASSWORD_LENGTH = 6;

    public static String generatePassword() {
        StringBuilder sb = new StringBuilder(PASSWORD_LENGTH);
        Random random = new Random();
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static boolean verifyPassword(String userInput, String generatedPassword) {
        return userInput.equals(generatedPassword);
    }

    public static void main(String[] args) {
        String generatedPassword = generatePassword();
        System.out.println("Generated password: " + generatedPassword);
        String userInput = "input from user";
        if (verifyPassword(userInput, generatedPassword)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }
}