package ZeroShot.codestral;
import java.util.Random;

public class Task54 {
    public static String generateOTP() {
        Random rnd = new Random();
        int number = 100000 + rnd.nextInt(900000);
        return String.valueOf(number);
    }

    public static boolean validateOTP(String inputOTP, String expectedOTP) {
        return inputOTP.equals(expectedOTP);
    }

    public static void main(String[] args) {
        String expectedOTP = generateOTP();
        System.out.println("Generated OTP: " + expectedOTP);

        // Test cases
        String[] testCases = {"123456", "654321", expectedOTP, "987654", "456789"};
        for (String testCase : testCases) {
            System.out.println("Input OTP: " + testCase + ", Valid: " + validateOTP(testCase, expectedOTP));
        }
    }
}