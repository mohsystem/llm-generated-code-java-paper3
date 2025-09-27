package ourMethod.gpt4o;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Task42 {
    private static final Map<String, String> userStore = new HashMap<>();

    public static boolean register(String username, String password) {
        if (userStore.containsKey(username)) {
            return false;
        }
        String hashedPassword = hashPassword(password);
        userStore.put(username, hashedPassword);
        return true;
    }

    public static boolean login(String username, String password) {
        String hashedPassword = userStore.get(username);
        if (hashedPassword == null) {
            return false;
        }
        return hashedPassword.equals(hashPassword(password));
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(register("user1", "password1")); // true
        System.out.println(register("user1", "password2")); // false
        System.out.println(login("user1", "password1")); // true
        System.out.println(login("user1", "password2")); // false
        System.out.println(login("user2", "password1")); // false
    }
}