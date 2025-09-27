package CoT.codestral;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task122 {
    private static Map<String, String> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        signUp(username, password);
        scanner.close();
    }

    public static void signUp(String username, String password) {
        if (!userDatabase.containsKey(username)) {
            userDatabase.put(username, hashPassword(password));
            System.out.println("User created successfully.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}