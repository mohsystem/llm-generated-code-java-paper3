package ourMethodv2.gpt4o;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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

class Database {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}

public class Task46 {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@(.+)$");

    public boolean validateEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public boolean validatePassword(String password) {
        return password.length() >= 8; // simple length check for password
    }

    public boolean registerUser(String name, String email, String password, Database db) {
        if (validateEmail(email) && validatePassword(password)) {
            User user = new User(name, email, password);
            db.addUser(user);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Task46 task = new Task46();
        Database db = new Database();

        System.out.println(task.registerUser("Alice", "alice@example.com", "password123", db)); // true
        System.out.println(task.registerUser("Bob", "invalid-email", "password123", db)); // false
        System.out.println(task.registerUser("Charlie", "charlie@example.com", "pass", db)); // false
        System.out.println(task.registerUser("David", "david@example.com", "securePass1", db)); // true
        System.out.println(task.registerUser("Eve", "eve@example.com", "anotherSecurePass2", db)); // true
    }
}