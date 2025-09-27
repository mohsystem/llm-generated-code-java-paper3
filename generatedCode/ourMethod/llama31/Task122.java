package ourMethod.llama31;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Task122 {
    public static void main(String[] args) {
        String password = "MySecretPassword";
        String hashedPassword = hashPassword(password);
        System.out.println("Hashed password: " + hashedPassword);
    }

    public static String hashPassword(String password) {
        try {
            // Generate a salt
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            // Hash the password
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest((password + new String(salt)).getBytes(StandardCharsets.UTF_8));

            // Combine salt and hashed password
            byte[] combined = new byte[salt.length + hashedBytes.length];
            System.arraycopy(salt, 0, combined, 0, salt.length);
            System.arraycopy(hashedBytes, 0, combined, salt.length, hashedBytes.length);

            return Base64.getEncoder().encodeToString(combined);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}