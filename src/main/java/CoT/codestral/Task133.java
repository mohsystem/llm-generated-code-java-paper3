package CoT.codestral;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Base64;

public class Task133 {
    private static Map<String, String> userDatabase = new HashMap<>();
    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        // test cases
        registerUser("user1", "oldPassword1");
        registerUser("user2", "oldPassword2");
        resetPassword("user1", "newPassword1");
        resetPassword("user2", "newPassword2");
    }

    public static void registerUser(String username, String password) {
        userDatabase.put(username, hashPassword(password));
    }

    public static void resetPassword(String username, String newPassword) {
        if (userDatabase.containsKey(username)) {
            userDatabase.put(username, hashPassword(newPassword));
            System.out.println("Password reset successful.");
        } else {
            System.out.println("User not found.");
        }
    }

    private static String hashPassword(String password) {
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String saltStr = Base64.getEncoder().encodeToString(salt);
        // In a real-world application, use a strong password hashing function like bcrypt or Argon2.
        return saltStr + password;
    }
}