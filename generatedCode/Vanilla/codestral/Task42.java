package Vanilla.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task42 {
    private Map<String, String> users = new HashMap<>();

    public void register(String username, String password) {
        users.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public static void main(String[] args) {
        Task42 authSystem = new Task42();
        authSystem.register("user1", "pass1");
        authSystem.register("user2", "pass2");

        System.out.println(authSystem.authenticate("user1", "pass1")); // true
        System.out.println(authSystem.authenticate("user2", "wrongPass")); // false
        System.out.println(authSystem.authenticate("nonexistentUser", "pass")); // false
    }
}