package Vanilla.gpt4o;
import java.util.HashMap;

public class Task136 {
    private HashMap<String, String> userDatabase;

    public Task136() {
        userDatabase = new HashMap<>();
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
        userDatabase.put("user3", "password3");
        userDatabase.put("user4", "password4");
        userDatabase.put("user5", "password5");
    }

    public boolean authenticate(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }

    public static void main(String[] args) {
        Task136 authSystem = new Task136();
        System.out.println(authSystem.authenticate("user1", "password1")); // true
        System.out.println(authSystem.authenticate("user2", "wrongpassword")); // false
        System.out.println(authSystem.authenticate("user3", "password3")); // true
        System.out.println(authSystem.authenticate("unknownuser", "password4")); // false
        System.out.println(authSystem.authenticate("user5", "password5")); // true
    }
}