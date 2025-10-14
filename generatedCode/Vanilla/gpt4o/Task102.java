package Vanilla.openai;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Task102 {

    private static Map<String, String> database = new HashMap<>();

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updatePassword(String username, String newPassword) {
        String hashedPassword = hashPassword(newPassword);
        database.put(username, hashedPassword);
        System.out.println("Password updated for user: " + username);
    }

    public static void main(String[] args) {
        updatePassword("user1", "password123");
        updatePassword("user2", "mysecurepassword");
        updatePassword("user3", "123456");
        updatePassword("user4", "letmein");
        updatePassword("user5", "password");
    }
}