package Vanilla.openai;
import java.util.Random;

public class Task54 {

    public static String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    public static void main(String[] args) {
        // 5 test cases for generating OTP
        for (int i = 0; i < 5; i++) {
            System.out.println("Generated OTP: " + generateOTP());
        }
    }
}