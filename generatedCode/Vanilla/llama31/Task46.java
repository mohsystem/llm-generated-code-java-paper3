package Vanilla.llama31;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task46 {
    public static void main(String[] args) {
        Map<String, User> database = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Test cases
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            registerUser(database, name, email, password);
        }

        // Display stored users
        for (User user : database.values()) {
            System.out.println("Name: " + user.name + ", Email: " + user.email + ", Password: " + user.password);
        }
    }

    public static void registerUser(Map<String, User> database, String name, String email, String password) {
        if (database.containsKey(email)) {
            System.out.println("Email already exists.");
            return;
        }
        database.put(email, new User(name, email, password));
        System.out.println("User registered successfully.");
    }

    static class User {
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