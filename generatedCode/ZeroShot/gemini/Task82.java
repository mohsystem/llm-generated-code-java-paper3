package ZeroShot.gemini;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Task82 {

    public static byte[] getSaltedPasswordHash(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        md.update(password.getBytes());
        return md.digest();
    }

    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String[] passwords = {"password123", "test", "securePassword", "1234567890", "MyStrongPassword"};
        for (String password : passwords) {
            byte[] salt = generateSalt();
            byte[] saltedHash = getSaltedPasswordHash(password, salt);
            System.out.println("Password: " + password);
            System.out.println("Salt: " + Arrays.toString(salt));
            System.out.println("Salted Hash: " + Arrays.toString(saltedHash));
            System.out.println();
        }
    }
}