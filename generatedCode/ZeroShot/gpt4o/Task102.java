package ZeroShot.gpt4o;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Task102 {
    private static Map<String, String> database = new HashMap<>();

    public static void updatePassword(String username, String newPassword) throws NoSuchAlgorithmException {
        String hashedPassword = hashPassword(newPassword);
        database.put(username, hashedPassword);
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        try {
            updatePassword("user1", "securePassword1");
            updatePassword("user2", "securePassword2");
            updatePassword("user3", "securePassword3");
            updatePassword("user4", "securePassword4");
            updatePassword("user5", "securePassword5");

            System.out.println(database);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}