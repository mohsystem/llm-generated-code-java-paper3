package CoT.codestral;
import java.security.SecureRandom;

public class Task54 {
    private static final SecureRandom random = new SecureRandom();
    private static final int PASSWORD_LENGTH = 6;

    public static String generateOTP() {
        int number = 100000 + random.nextInt(900000);
        return String.valueOf(number);
    }

    public static boolean validateOTP(String userInput, String generatedOTP) {
        return userInput.equals(generatedOTP);
    }

    public static void main(String[] args) {
        String otp = generateOTP();
        System.out.println("Generated OTP: " + otp);

        // Test cases
        System.out.println(validateOTP("123456", otp));
        System.out.println(validateOTP("654321", otp));
        System.out.println(validateOTP("999999", otp));
        System.out.println(validateOTP(otp, otp));
    }
}