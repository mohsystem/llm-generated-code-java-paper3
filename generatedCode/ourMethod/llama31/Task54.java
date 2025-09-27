package ourMethod.llama31;
import java.security.SecureRandom;
import java.util.Scanner;

public class Task54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Simulate authentication (in a real scenario, this would involve checking against a database)
        if (authenticate(username, password)) {
            String otp = generateOTP();
            System.out.println("Your OTP is: " + otp);
            System.out.print("Enter the OTP: ");
            String userOtp = scanner.nextLine();

            if (verifyOtp(otp, userOtp)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid OTP. Login failed.");
            }
        } else {
            System.out.println("Invalid username or password. Login failed.");
        }
    }

    public static boolean authenticate(String username, String password) {
        // In a real scenario, this would involve checking against a database
        return username.equals("user") && password.equals("password");
    }

    public static String generateOTP() {
        SecureRandom random = new SecureRandom();
        int otp = random.nextInt(999999); // Generate a 6-digit OTP
        return String.format("%06d", otp); // Ensure the OTP is always 6 digits
    }

    public static boolean verifyOtp(String generatedOtp, String userOtp) {
        return generatedOtp.equals(userOtp);
    }
}