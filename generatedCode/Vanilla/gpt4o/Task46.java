package Vanilla.gpt4o;
import java.util.ArrayList;
import java.util.List;

public class Task46 {
    static class User {
        String name;
        String email;
        String password;

        User(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Email: " + email;
        }
    }

    static class UserDatabase {
        List<User> users = new ArrayList<>();

        void registerUser(String name, String email, String password) {
            User user = new User(name, email, password);
            users.add(user);
        }

        List<User> getUsers() {
            return users;
        }
    }

    public static void main(String[] args) {
        UserDatabase db = new UserDatabase();

        // Test cases
        db.registerUser("Alice", "alice@example.com", "password123");
        db.registerUser("Bob", "bob@example.com", "password456");
        db.registerUser("Charlie", "charlie@example.com", "password789");
        db.registerUser("David", "david@example.com", "password101112");
        db.registerUser("Eve", "eve@example.com", "password131415");

        for (User user : db.getUsers()) {
            System.out.println(user);
        }
    }
}