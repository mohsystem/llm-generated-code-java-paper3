package ZeroShot.gpt4o;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Task82 {
    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt.getBytes());
        byte[] hashedPassword = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    public static String getSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        for (int i = 0; i < 5; i++) {
            String salt = getSalt();
            System.out.println("Test " + (i + 1) + ": " + hashPassword("password" + i, salt));
        }
    }
}