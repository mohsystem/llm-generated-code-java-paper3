package CoT.gemini;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Task54 {

    private static final int OTP_LENGTH = 6;

    public static String generateOTP() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }

    public static boolean verifyOTP(String userOTP, String generatedOTP) {

        try {
            // Introduce a small delay to mitigate timing attacks
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return userOTP.equals(generatedOTP);

    }


    public static void main(String[] args) {
        String[] testUsernames = {"user1", "user2", "user3", "user4", "user5"};
        for (String username : testUsernames) {
            String otp = generateOTP();
            System.out.println(username + ": " + otp); // In real application, send OTP through secure channel
            // Simulate user entering OTP
            String userEnteredOTP = otp; // Replace with actual user input
            if (verifyOTP(userEnteredOTP, otp)) {
                System.out.println(username + ": Login successful");
            } else {
                System.out.println(username + ": Login failed");
            }
        }
    }
}