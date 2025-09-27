package CoT.gpt4o;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Task102 {

    private static Map<String, String> database = new HashMap<>();

    public static boolean updatePassword(String username, String newPassword) {
        try {
            String hashedPassword = hashPassword(newPassword);
            database.put(username, hashedPassword);
            return true;
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        System.out.println(updatePassword("user1", "password123"));
        System.out.println(updatePassword("user2", "newpassword456"));
        System.out.println(updatePassword("user3", "anotherpassword789"));
        System.out.println(updatePassword("user4", "yetanotherpassword012"));
        System.out.println(updatePassword("user5", "lastpassword345"));
    }
}