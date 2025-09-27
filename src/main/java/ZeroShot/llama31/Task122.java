package ZeroShot.llama31;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.nio.charset.StandardCharsets;

public class Task122 {
    public static void main(String[] args) {
        // Test cases
        String[] usernames = {"user1", "user2", "user3", "user4", "user5"};
        String[] passwords = {"password1", "password2", "password3", "password4", "password5"};

        for (int i = 0; i < usernames.length; i++) {
            String[] result = signUp(usernames[i], passwords[i]);
            System.out.println("Username: " + usernames[i] + ", Salt: " + result[0] + ", Hash: " + result[1]);
        }
    }

    public static String[] signUp(String username, String password) {
        byte[] salt = generateSalt();
        String saltHex = bytesToHex(salt);
        String passwordHash = hashPassword(password, salt);
        return new String[]{saltHex, passwordHash};
    }

    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public static String hashPassword(String password, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = (password + bytesToHex(salt)).getBytes(StandardCharsets.UTF_8);
            byte[] hashBytes = md.digest(bytes);
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}