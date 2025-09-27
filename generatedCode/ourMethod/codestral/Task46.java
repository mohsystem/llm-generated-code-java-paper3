package ourMethod.codestral;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Task46 {
    private Map<String, User> users = new HashMap<>();

    public void registerUser(String name, String email, String password) {
        if (users.containsKey(email)) {
            throw new IllegalArgumentException("Email already exists");
        }
        String hashedPassword = getHashedPassword(password);
        User user = new User(name, email, hashedPassword);
        users.put(email, user);
    }

    private String getHashedPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Task46 task = new Task46();
        task.registerUser("John Doe", "john.doe@example.com", "password123");
        task.registerUser("Jane Smith", "jane.smith@example.com", "securepassword");
    }
}

class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}