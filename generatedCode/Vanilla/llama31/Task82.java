package Vanilla.llama31;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task82 {
    public static String hashPasswordWithSalt(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest((password + salt).getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] passwords = {"password1", "password2", "password3", "password4", "password5"};
        String[] salts = {"salt1", "salt2", "salt3", "salt4", "salt5"};

        for (int i = 0; i < 5; i++) {
            String hashedPassword = hashPasswordWithSalt(passwords[i], salts[i]);
            System.out.println("Password: " + passwords[i] + ", Salt: " + salts[i] + ", Hash: " + hashedPassword);
        }
    }
}