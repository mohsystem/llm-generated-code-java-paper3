package CoT.openai;
import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task122 {
    private Map<String, String> userDatabase;

    public Task122() {
        userDatabase = new HashMap<>();
    }

    public boolean signup(String username, String password) {
        if (userDatabase.containsKey(username)) {
            return false; // User already exists
        }
        String hashedPassword = hashPassword(password);
        if (hashedPassword != null) {
            userDatabase.put(username, hashedPassword);
            return true;
        }
        return false;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Task122 task = new Task122();
        System.out.println(task.signup("user1", "password1")); // true
        System.out.println(task.signup("user1", "password2")); // false
        System.out.println(task.signup("user2", "password3")); // true
        System.out.println(task.signup("user3", "password4")); // true
        System.out.println(task.signup("user2", "password5")); // false
    }
}