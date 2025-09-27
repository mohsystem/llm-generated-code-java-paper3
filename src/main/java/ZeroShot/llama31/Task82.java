package ZeroShot.llama31;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task82 {
    public static String hashPasswordWithSalt(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] input = (password + salt).getBytes(StandardCharsets.UTF_8);
            byte[] hashBytes = md.digest(input);
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        String[] passwords = {"password123", "securepassword", "anotherpassword", "testpassword", "examplepassword"};
        String[] salts = {"salt1", "salt2", "salt3", "salt4", "salt5"};

        for (int i = 0; i < passwords.length; i++) {
            String hashedPassword = hashPasswordWithSalt(passwords[i], salts[i]);
            System.out.println("Password: " + passwords[i] + ", Salt: " + salts[i] + ", Hash: " + hashedPassword);
        }
    }
}