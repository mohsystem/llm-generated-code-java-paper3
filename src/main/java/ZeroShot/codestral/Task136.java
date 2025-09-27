package ZeroShot.codestral;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task136 {
    private static Map<String, String> users = new HashMap<>();

    static {
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public static boolean authenticate(String username, String password) {
        return users.getOrDefault(username, "").equals(password);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (authenticate(username, password)) {
            System.out.println("Authentication successful");
        } else {
            System.out.println("Authentication failed");
        }
    }
}