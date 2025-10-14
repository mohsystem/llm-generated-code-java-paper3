package ZeroShot.openai;
import java.util.HashMap;
import java.util.Scanner;

public class Task136 {

    private static HashMap<String, String> users = new HashMap<>();

    static {
        // Sample users
        users.put("user1", "password123");
        users.put("user2", "pass456");
        users.put("admin", "adminpass");
    }

    public static boolean authenticate(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(authenticate("user1", "password123")); // true
        System.out.println(authenticate("user2", "pass456")); // true
        System.out.println(authenticate("admin", "adminpass")); // true
        System.out.println(authenticate("user1", "wrongpass")); // false
        System.out.println(authenticate("unknown", "password")); // false
    }
}