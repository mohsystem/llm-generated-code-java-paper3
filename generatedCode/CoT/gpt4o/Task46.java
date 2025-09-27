package CoT.gpt4o;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
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

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "'}";
    }
}

class Database {
    private List<User> users = new ArrayList<>();

    public boolean addUser(User user) {
        return users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}

public class Task46 {

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isValidPassword(String password) {
        return password.length() >= 8; // Basic validation for demonstration
    }

    public static String registerUser(String name, String email, String password, Database db) {
        if (!isValidEmail(email)) {
            return "Invalid email format";
        }
        if (!isValidPassword(password)) {
            return "Password must be at least 8 characters";
        }
        User user = new User(name, email, password);
        db.addUser(user);
        return "Registration successful";
    }

    public static void main(String[] args) {
        Database db = new Database();
        System.out.println(registerUser("Alice", "alice@example.com", "password123", db));
        System.out.println(registerUser("Bob", "bob_at_example.com", "pass", db));
        System.out.println(registerUser("Charlie", "charlie@example.com", "charlie123", db));
        System.out.println(registerUser("Dave", "dave@example", "davepass", db));
        System.out.println(registerUser("Eve", "eve@example.com", "evepass123", db));

        System.out.println("Registered Users: " + db.getUsers());
    }
}