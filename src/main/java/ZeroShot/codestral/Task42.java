package ZeroShot.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task42 {
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        // Test cases
        registerUser("user1", "password1");
        registerUser("user2", "password2");

        System.out.println(authenticateUser("user1", "password1")); // true
        System.out.println(authenticateUser("user2", "wrong_password")); // false
    }

    public static void registerUser(String username, String password) {
        users.put(username, password);
    }

    public static boolean authenticateUser(String username, String password) {
        return users.getOrDefault(username, "").equals(password);
    }
}