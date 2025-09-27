package ourMethod.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task42 {
    private Map<String, String> users = new HashMap<>();

    public void addUser(String username, String password) {
        users.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        if (!users.containsKey(username)) {
            return false;
        }
        return users.get(username).equals(password);
    }

    public static void main(String[] args) {
        Task42 authSystem = new Task42();
        authSystem.addUser("user1", "password1");

        System.out.println(authSystem.authenticate("user1", "password1"));  // true
        System.out.println(authSystem.authenticate("user1", "wrongpassword"));  // false
        System.out.println(authSystem.authenticate("user2", "password1"));  // false
    }
}