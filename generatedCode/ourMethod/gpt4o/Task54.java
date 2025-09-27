package ourMethod.gpt4o;
import java.util.Random;

public class Task54 {

    public static String generateOTP(int length) {
        String numbers = "0123456789";
        Random random = new Random();
        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < length; i++) {
            otp.append(numbers.charAt(random.nextInt(numbers.length())));
        }
        return otp.toString();
    }

    public static boolean verifyOTP(String userInput, String generatedOTP) {
        return userInput.equals(generatedOTP);
    }

    public static void main(String[] args) {
        // Test cases
        String otp1 = generateOTP(6);
        System.out.println("Generated OTP: " + otp1);
        System.out.println("Verification: " + verifyOTP(otp1, otp1)); // Should return true

        String otp2 = generateOTP(6);
        System.out.println("Generated OTP: " + otp2);
        System.out.println("Verification: " + verifyOTP("123456", otp2)); // Should return false

        String otp3 = generateOTP(6);
        System.out.println("Generated OTP: " + otp3);
        System.out.println("Verification: " + verifyOTP(otp3, otp3)); // Should return true

        String otp4 = generateOTP(6);
        System.out.println("Generated OTP: " + otp4);
        System.out.println("Verification: " + verifyOTP("000000", otp4)); // Should return false

        String otp5 = generateOTP(6);
        System.out.println("Generated OTP: " + otp5);
        System.out.println("Verification: " + verifyOTP(otp5, otp5)); // Should return true
    }
}