package Vanilla.llama31;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

public class Task42 {
    private static Map<String, String> users = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        testCases();
    }

    public static void register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return;
        }
        users.put(username, hashPassword(password));
        System.out.println("User registered successfully.");
    }

    public static void login(String username, String password) {
        if (!users.containsKey(username)) {
            System.out.println("Username does not exist.");
            return;
        }
        if (users.get(username).equals(hashPassword(password))) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Incorrect password.");
        }
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void testCases() {
        register("user1", "password1");
        register("user2", "password2");
        login("user1", "password1");
        login("user1", "wrongpassword");
        login("user3", "password3");
    }
}