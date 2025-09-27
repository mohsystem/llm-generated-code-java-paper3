package CoT.llama31;
import java.security.SecureRandom;
import java.util.Base64;

public class Task56 {
    public static void main(String[] args) {
        // Test cases
        String[] usernames = {"user1", "user2", "user3", "user4", "user5"};
        for (String username : usernames) {
            String token = generateAuthenticationToken(username);
            System.out.println("Token for " + username + ": " + token);
        }
    }

    public static String generateAuthenticationToken(String username) {
        // Problem understanding: Generate a unique token for user authentication
        // Security requirements: Use secure random number generation to prevent predictability

        // Secure coding generation: Use SecureRandom and Base64 encoding
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
}