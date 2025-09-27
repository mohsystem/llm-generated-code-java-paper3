package ZeroShot.llama31;
import java.util.Random;

public class Task85 {
    public static void main(String[] args) {
        // Test cases
        System.out.println(generateRandomString(5));
        System.out.println(generateRandomString(10));
        System.out.println(generateRandomString(7));
        System.out.println(generateRandomString(3));
        System.out.println(generateRandomString(15));
    }

    public static String generateRandomString(int length) {
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String allAlphabet = upperAlphabet + lowerAlphabet;

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allAlphabet.length());
            char randomChar = allAlphabet.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}