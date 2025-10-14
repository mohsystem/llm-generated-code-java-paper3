package ourMethodv2.gpt4o;
import java.util.Random;

public class Task54 {

    public static String generateOTP(int length) {
        String numbers = "0123456789";
        Random rnd = new Random();
        StringBuilder otp = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            int index = rnd.nextInt(numbers.length());
            otp.append(numbers.charAt(index));
        }
        return otp.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(generateOTP(6));
        System.out.println(generateOTP(6));
        System.out.println(generateOTP(6));
        System.out.println(generateOTP(6));
        System.out.println(generateOTP(6));
    }
}