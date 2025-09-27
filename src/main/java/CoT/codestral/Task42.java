package CoT.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task42 {
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        registerUser("user1", "password1");
        System.out.println(authenticateUser("user1", "password1")); // true
        System.out.println(authenticateUser("user1", "wrongPassword")); // false
    }

    public static void registerUser(String username, String password) {
        users.put(username, password);
    }

    public static boolean authenticateUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}