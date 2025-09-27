package CoT.llama31;
import java.util.Random;

public class Task85 {
    public static void main(String[] args) {
        // Test cases
        System.out.println(generateRandomString(5));
        System.out.println(generateRandomString(10));
        System.out.println(generateRandomString(15));
        System.out.println(generateRandomString(20));
        System.out.println(generateRandomString(25));
    }

    public static String generateRandomString(int length) {
        // Define ASCII letters
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String allLetters = upperAlphabet + lowerAlphabet;

        // Create random string builder
        StringBuilder sb = new StringBuilder();

        // Create an object of Random class
        Random random = new Random();

        // Generate random string
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allLetters.length());
            char randomChar = allLetters.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}