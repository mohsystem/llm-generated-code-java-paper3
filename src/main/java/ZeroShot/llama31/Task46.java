package ZeroShot.llama31;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task46 {
    public static void main(String[] args) {
        Map<String, User> database = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Test cases
        registerUser(database, "user1", "user1@example.com", "password1", scanner);
        registerUser(database, "user2", "user2@example.com", "password2", scanner);
        registerUser(database, "user3", "user3@example.com", "password3", scanner);
        loginUser(database, "user1", "password1", scanner);
        loginUser(database, "user2", "wrongpassword", scanner);
    }

    public static void registerUser(Map<String, User> database, String name, String email, String password, Scanner scanner) {
        if (database.containsKey(name)) {
            System.out.println("Username already exists.");
            return;
        }
        database.put(name, new User(name, email, password));
        System.out.println("Registration successful.");
    }

    public static void loginUser(Map<String, User> database, String name, String password, Scanner scanner) {
        if (database.containsKey(name) && database.get(name).password.equals(password)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public static class User {
        String name;
        String email;
        String password;

        public User(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }
    }
}