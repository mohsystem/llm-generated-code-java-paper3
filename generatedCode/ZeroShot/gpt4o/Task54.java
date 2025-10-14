package ZeroShot.openai;
import java.util.Random;
import java.util.Scanner;

public class Task54 {

    // Method to generate a random OTP
    public static String generateOTP() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            otp.append(random.nextInt(10)); // Generate a digit from 0 to 9
        }
        return otp.toString();
    }

    // Simulated method to send OTP to user (here just prints to console)
    public static void sendOTP(String otp) {
        System.out.println("OTP for login: " + otp);
    }

    // Simulated method for 2FA process
    public static boolean authenticateUser(String enteredOtp, String generatedOtp) {
        return enteredOtp.equals(generatedOtp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Test cases
        for (int i = 0; i < 5; i++) {
            String otp = generateOTP();
            sendOTP(otp);
            System.out.print("Enter received OTP: ");
            String enteredOtp = scanner.nextLine();
            if (authenticateUser(enteredOtp, otp)) {
                System.out.println("Authentication Successful");
            } else {
                System.out.println("Authentication Failed");
            }
        }
        scanner.close();
    }
}