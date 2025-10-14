package ourMethod.openai;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Task102 {
    private Map<String, String> database = new HashMap<>();

    public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    public boolean updatePassword(String username, String newPassword) {
        try {
            String hashedPassword = hashPassword(newPassword);
            database.put(username, hashedPassword);
            return true;
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Task102 task = new Task102();

        System.out.println(task.updatePassword("user1", "newPassword1"));
        System.out.println(task.updatePassword("user2", "newPassword2"));
        System.out.println(task.updatePassword("user3", "newPassword3"));
        System.out.println(task.updatePassword("user4", "newPassword4"));
        System.out.println(task.updatePassword("user5", "newPassword5"));
    }
}