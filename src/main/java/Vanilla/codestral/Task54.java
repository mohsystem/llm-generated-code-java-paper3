package Vanilla.codestral;
import java.util.Random;

public class Task54 {
    public static int generateOTP() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }

    public static boolean verifyOTP(int userInput, int otp) {
        return userInput == otp;
    }

    public static void main(String[] args) {
        int otp = generateOTP();
        System.out.println("Generated OTP: " + otp);

        // For testing purposes, we'll assume the user inputs the OTP correctly
        int userInput = otp;
        if (verifyOTP(userInput, otp)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Invalid OTP");
        }
    }
}