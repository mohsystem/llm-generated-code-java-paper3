package ZeroShot.codestral;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Task82 {
    private static final String ALGORITHM = "SHA-256";

    public static String generateSalt() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
        digest.update(salt.getBytes());
        byte[] hash = digest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String[] passwords = {"password1", "password2", "password3", "password4", "password5"};
        for (String password : passwords) {
            String salt = generateSalt();
            String hashedPassword = hashPassword(password, salt);
            System.out.println("Password: " + password + ", Salt: " + salt + ", Hashed Password: " + hashedPassword);
        }
    }
}