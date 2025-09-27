package Vanilla.codestral;
// Java
import java.util.HashMap;
import java.util.Map;

public class Task122 {
    private Map<String, String> users = new HashMap<>();

    public void signUp(String username, String password) {
        users.put(username, password);
    }

    public static void main(String[] args) {
        Task122 task = new Task122();
        task.signUp("user1", "pass1");
        task.signUp("user2", "pass2");
        // Add more test cases as needed
    }
}