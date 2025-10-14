package ourMethodv2.gpt4o;
import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Task42 {
    private Map<String, String> userDatabase = new HashMap<>();
    private Map<String, String> saltDatabase = new HashMap<>();
    private static final SecureRandom secureRandom = new SecureRandom();

    public void registerUser(String username, String password) {
        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);
        userDatabase.put(username, hashedPassword);
        saltDatabase.put(username, salt);
    }

    public boolean authenticateUser(String username, String password) {
        String salt = saltDatabase.get(username);
        if (salt == null) {
            return false;
        }
        String hashedPassword = hashPassword(password, salt);
        return hashedPassword.equals(userDatabase.get(username));
    }

    private String generateSalt() {
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    private String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(Base64.getDecoder().decode(salt));
            byte[] hashedPassword = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Task42 authSystem = new Task42();
        authSystem.registerUser("user1", "password123");
        authSystem.registerUser("user2", "mySecurePassword");
        authSystem.registerUser("user3", "anotherPassword");
        authSystem.registerUser("user4", "password4");
        authSystem.registerUser("user5", "password5");

        System.out.println(authSystem.authenticateUser("user1", "password123")); // true
        System.out.println(authSystem.authenticateUser("user2", "wrongPassword")); // false
        System.out.println(authSystem.authenticateUser("user3", "anotherPassword")); // true
        System.out.println(authSystem.authenticateUser("user4", "password4")); // true
        System.out.println(authSystem.authenticateUser("user5", "wrongPassword")); // false
    }
}