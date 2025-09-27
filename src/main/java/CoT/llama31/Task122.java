package CoT.llama31;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task122 {
    public static String hashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(hash);
    }

    public static boolean verifyPassword(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String[] parts = storedPassword.split(":");
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] hash = Base64.getDecoder().decode(parts[1]);
        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = f.generateSecret(spec).getEncoded();
        return java.util.Arrays.equals(hash, testHash);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String[] passwords = {"password123", "mysecret", "testpassword", "securepassword", "anotherpassword"};
        for (String password : passwords) {
            String hashedPassword = hashPassword(password);
            System.out.println("Password: " + password + ", Hashed Password: " + hashedPassword);
            System.out.println("Verification: " + verifyPassword(password, hashedPassword));
        }
    }
}