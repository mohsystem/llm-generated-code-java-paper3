package CoT.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task136 {
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        // Add some users for testing
        users.put("user1", "password1");
        users.put("user2", "password2");

        // Test cases
        System.out.println(authenticate("user1", "password1")); // true
        System.out.println(authenticate("user1", "wrongpassword")); // false
        System.out.println(authenticate("user3", "password3")); // false
    }

    public static boolean authenticate(String username, String password) {
        String storedPassword = users.get(username);
        if (storedPassword != null && storedPassword.equals(password)) {
            return true;
        }
        return false;
    }
}