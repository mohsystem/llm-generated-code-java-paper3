package ourMethod.openai;
import java.util.Random;

public class Task85 {
    public static String generateRandomString(int length) {
        if (length <= 0) return "";
        StringBuilder randomString = new StringBuilder(length);
        Random random = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            randomString.append(alphabet.charAt(index));
        }
        return randomString.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(generateRandomString(5));
        System.out.println(generateRandomString(10));
        System.out.println(generateRandomString(15));
        System.out.println(generateRandomString(20));
        System.out.println(generateRandomString(25));
    }
}