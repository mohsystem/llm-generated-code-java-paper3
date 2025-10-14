package ourMethodv2.gpt4o;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Task82 {
    public static String generateHashWithSalt(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] hashedPassword = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateRandomSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static void main(String[] args) {
        String salt = generateRandomSalt();
        System.out.println(generateHashWithSalt("password1", salt));
        System.out.println(generateHashWithSalt("password2", salt));
        System.out.println(generateHashWithSalt("password3", salt));
        System.out.println(generateHashWithSalt("password4", salt));
        System.out.println(generateHashWithSalt("password5", salt));
    }
}