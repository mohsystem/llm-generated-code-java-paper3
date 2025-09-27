package ZeroShot.gemini;
import java.util.Random;
import java.util.Scanner;

class Task54 {

    public static String generateOTP(int length) {
        String numbers = "0123456789";
        Random random = new Random();
        char[] otp = new char[length];

        for (int i = 0; i < length; i++) {
            otp[i] = numbers.charAt(random.nextInt(numbers.length()));
        }
        return new String(otp);
    }

    public static boolean twoFactorAuth(String username, String password, int otpLength) {
        Scanner scanner = new Scanner(System.in);
        if (username.equals("user") && password.equals("password")) { // Replace with actual authentication logic
            String otp = generateOTP(otpLength);
            System.out.println("Your OTP is: " + otp);
            System.out.print("Enter OTP: ");
            String enteredOTP = scanner.nextLine();
            return otp.equals(enteredOTP);
        }
        return false;

    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(twoFactorAuth("user", "password", 6));
        System.out.println(twoFactorAuth("user", "wrongpassword", 6));
        System.out.println(twoFactorAuth("wronguser", "password", 6));
        System.out.println(twoFactorAuth("user", "password", 4));
        System.out.println(twoFactorAuth("user", "password", 8));

    }
}