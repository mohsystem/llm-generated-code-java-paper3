package CoT.llama31;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class Task42 {
    private static Map<String, String> users = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws NoSuchAlgorithmException {
        testCases();
    }

    public static void register() throws NoSuchAlgorithmException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        String hashedPassword = hashPassword(password);
        users.put(username, hashedPassword);
        System.out.println("Registration successful");
    }

    public static void login() throws NoSuchAlgorithmException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        String hashedPassword = hashPassword(password);
        if (users.containsKey(username) && users.get(username).equals(hashedPassword)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Invalid credentials");
        }
    }

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void testCases() throws NoSuchAlgorithmException {
        // Test case 1: Register a user
        register();
        // Test case 2: Login with correct credentials
        login();
        // Test case 3: Login with incorrect credentials
        login();
        // Test case 4: Register another user
        register();
        // Test case 5: Login with correct credentials for the second user
        login();
    }
}