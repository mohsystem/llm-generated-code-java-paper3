package ZeroShot.llama31;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task136 {
    private static Map<String, String> users = new HashMap<>();

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void registerUser(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return;
        }
        users.put(username, hashPassword(password));
        System.out.println("User registered successfully.");
    }

    public static boolean loginUser(String username, String password) {
        if (!users.containsKey(username)) {
            System.out.println("Invalid username or password.");
            return false;
        }
        String hashedPassword = users.get(username);
        if (hashedPassword.equals(hashPassword(password))) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    registerUser(username, password);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    loginUser(username, password);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}