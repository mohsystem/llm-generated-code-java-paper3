package Vanilla.llama31;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task122 {
    public static void main(String[] args) {
        // Test cases
        String[] usernames = {"user1", "user2", "user3", "user4", "user5"};
        String[] passwords = {"password1", "password2", "password3", "password4", "password5"};

        for (int i = 0; i < usernames.length; i++) {
            String hashedPassword = hashPassword(passwords[i]);
            System.out.println("Username: " + usernames[i] + ", Hashed Password: " + hashedPassword);
        }
    }

    public static String hashPassword(String password) {
        try {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[512];
            random.nextBytes(salt);
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 1000, 256);
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            byte[] hash = f.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        String[] parts = hashedPassword.split(":");
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] expectedHash = Base64.getDecoder().decode(parts[1]);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 1000, 256);
        SecretKeyFactory f;
        try {
            f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            byte[] actualHash = f.generateSecret(spec).getEncoded();
            return java.util.Arrays.equals(expectedHash, actualHash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}