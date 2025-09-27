package Vanilla.gemini;
import java.util.Random;

class Task54 {

    public static String generateOTP(int length) {
        String numbers = "0123456789";
        Random random = new Random();
        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < length; i++) {
            otp.append(numbers.charAt(random.nextInt(numbers.length())));
        }

        return otp.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateOTP(6));
        System.out.println(generateOTP(8));
        System.out.println(generateOTP(4));
        System.out.println(generateOTP(6));
        System.out.println(generateOTP(10));

    }
}