package ZeroShot.llama31;
import java.util.Random;
import java.util.Scanner;

public class Task54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Test cases
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter username:");
            String username = scanner.nextLine();
            System.out.println("Enter password:");
            String password = scanner.nextLine();

            if (authenticateUser(username, password, random, scanner)) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }
        }
    }

    public static boolean authenticateUser(String username, String password, Random random, Scanner scanner) {
        // Simulate database check (for simplicity, assume valid credentials)
        if (!username.equals("test") || !password.equals("test")) {
            return false;
        }

        // Generate OTP
        String otp = generateOTP(random);
        System.out.println("OTP sent to your device: " + otp);

        // Prompt user to enter OTP
        System.out.println("Enter OTP:");
        String userOtp = scanner.nextLine();

        return otp.equals(userOtp);
    }

    public static String generateOTP(Random random) {
        int otp = random.nextInt(999999); // Generate 6-digit OTP
        return String.format("%06d", otp); // Ensure leading zeros
    }
}