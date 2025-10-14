package Vanilla.openai;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task42 {
    private Map<String, String> userDatabase = new HashMap<>();

    public boolean register(String username, String password) {
        if (userDatabase.containsKey(username)) {
            return false;
        }
        userDatabase.put(username, password);
        return true;
    }

    public boolean login(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }

    public static void main(String[] args) {
        Task42 authSystem = new Task42();
        System.out.println(authSystem.register("user1", "pass1")); // true
        System.out.println(authSystem.register("user1", "pass1")); // false
        System.out.println(authSystem.login("user1", "pass1")); // true
        System.out.println(authSystem.login("user2", "pass2")); // false
        System.out.println(authSystem.login("user1", "wrongpass")); // false
    }
}