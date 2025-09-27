package ourMethod.gemini;
import java.util.Random;
import java.util.Scanner;

public class Task54 {

    public static String generateOTP(int length) {
        String numbers = "0123456789";
        Random random = new Random();
        char[] otp = new char[length];

        for (int i = 0; i < length; i++) {
            otp[i] = numbers.charAt(random.nextInt(numbers.length()));
        }
        return new String(otp);
    }

    public static boolean twoFactorAuthentication(String username, String password, int otpLength) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String enteredUsername = scanner.nextLine();

        System.out.println("Enter password:");
        String enteredPassword = scanner.nextLine();


        if (username.equals(enteredUsername) && password.equals(enteredPassword)) {
            String otp = generateOTP(otpLength);
            System.out.println("Generated OTP: " + otp);

            System.out.println("Enter OTP:");
            String enteredOTP = scanner.nextLine();

            return otp.equals(enteredOTP);

        } else {
            return false;
        }


    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(twoFactorAuthentication("user1", "password123", 6));
        System.out.println(twoFactorAuthentication("user2", "securepass", 4));
        System.out.println(twoFactorAuthentication("user3", "mypassword", 8));
        System.out.println(twoFactorAuthentication("user1", "wrongpassword", 6));
        System.out.println(twoFactorAuthentication("wronguser", "password123", 6));

    }
}