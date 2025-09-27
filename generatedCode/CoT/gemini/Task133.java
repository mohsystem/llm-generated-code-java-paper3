package CoT.gemini;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

public class Task133 {

    public static String resetPassword(String username) {
        // Generate a secure random token
        SecureRandom sr;
        try {
            sr = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            return "Error generating reset token.";
        }
        byte[] tokenBytes = new byte[32]; // Generate 32 bytes (256 bits)
        sr.nextBytes(tokenBytes);
        String resetToken = Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);

        // In a real application, store the token associated with the username in a database
        // and send it to the user via email or other secure means.

        // Here, we just simulate printing the token.
        System.out.println("Reset token for " + username + ": " + resetToken);
        return resetToken;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Test 1:");
        resetPassword("user123");

        System.out.println("\nTest 2:");
        resetPassword("testuser");

        System.out.println("\nTest 3:");
        resetPassword("anotherUser");

        System.out.println("\nTest 4:");
        resetPassword("special_char@user");

        System.out.println("\nTest 5:");
        resetPassword("12345");

        scanner.close();

    }
}