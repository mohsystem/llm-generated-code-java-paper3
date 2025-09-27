package CoT.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task46 {
    private Map<String, User> users = new HashMap<>();

    public void registerUser(String name, String email, String password) {
        User user = new User(name, email, password);
        users.put(email, user);
    }

    public static void main(String[] args) {
        Task46 system = new Task46();
        system.registerUser("John Doe", "john.doe@example.com", "password123");
    }
}

class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}