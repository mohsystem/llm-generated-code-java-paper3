package Vanilla.gemini;
import java.util.HashMap;
import java.util.Map;

class Task46 {
    private Map<String, User> users = new HashMap<>();

    static class User {
        String name;
        String email;
        String password;

        User(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }
    }
    
    public void registerUser(String name, String email, String password) {
        if (users.containsKey(email)) {
            System.out.println("User with this email already exists.");
            return;
        }
        User newUser = new User(name, email, password);
        users.put(email, newUser);
        System.out.println("User registered successfully.");

    }

    public static void main(String[] args) {
        Task46 registrationSystem = new Task46();
        registrationSystem.registerUser("John Doe", "john.doe@example.com", "password123");
        registrationSystem.registerUser("Jane Doe", "jane.doe@example.com", "password456");
        registrationSystem.registerUser("Peter Pan", "peter.pan@example.com", "password789");
        registrationSystem.registerUser("John Doe", "john.doe@example.com", "new_password");
        registrationSystem.registerUser("Alice Wonderland", "alice@example.com", "wonderland123");

    }
}