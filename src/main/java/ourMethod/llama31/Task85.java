package ourMethod.llama31;
import java.util.Random;

public class Task85 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int length = 10 + i * 2; // Test with different lengths
            System.out.println("Random String of length " + length + ": " + generateRandomString(length));
        }
    }

    public static String generateRandomString(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));
        }
        return sb.toString();
    }
}