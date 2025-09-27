package Vanilla.llama31;
import java.util.Random;
import java.util.Scanner;

public class Task54 {
    public static void main(String[] args) {
        testCases();
    }

    public static void testCases() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter username and password (separated by space):");
            String[] credentials = scanner.nextLine().split(" ");
            String username = credentials[0];
            String password = credentials[1];
            if (authenticate(username, password, scanner)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }
        }
    }

    public static boolean authenticate(String username, String password, Scanner scanner) {
        // Simulate database check (for simplicity, assume credentials are valid)
        if (username.equals("user") && password.equals("password")) {
            String otp = generateOTP();
            System.out.println("Enter the OTP sent to your phone: " + otp);
            String userOtp = scanner.nextLine();
            return otp.equals(userOtp);
        }
        return false;
    }

    public static String generateOTP() {
        Random rand = new Random();
        int otp = rand.nextInt(999999); // Generate 6-digit OTP
        return String.format("%06d", otp);
    }
}