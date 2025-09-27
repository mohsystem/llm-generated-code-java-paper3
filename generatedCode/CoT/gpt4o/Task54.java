package CoT.gpt4o;
import java.util.Random;

public class Task54 {

    // Method to generate a random OTP
    public String generateOTP(int length) {
        String numbers = "0123456789";
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(numbers.length());
            otp.append(numbers.charAt(index));
        }
        return otp.toString();
    }

    public static void main(String[] args) {
        Task54 task = new Task54();
        
        // Test cases
        System.out.println("Test Case 1: OTP is " + task.generateOTP(6));
        System.out.println("Test Case 2: OTP is " + task.generateOTP(6));
        System.out.println("Test Case 3: OTP is " + task.generateOTP(6));
        System.out.println("Test Case 4: OTP is " + task.generateOTP(6));
        System.out.println("Test Case 5: OTP is " + task.generateOTP(6));
    }
}