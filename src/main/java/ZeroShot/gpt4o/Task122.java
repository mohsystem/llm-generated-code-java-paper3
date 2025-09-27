package ZeroShot.gpt4o;
import java.util.HashMap;
import java.util.Scanner;

public class Task122 {
    private static HashMap<String, String> users = new HashMap<>();

    public static boolean signup(String username, String password) {
        if (users.containsKey(username)) {
            return false; // User already exists
        }
        String hashedPassword = hashPassword(password);
        users.put(username, hashedPassword);
        return true;
    }

    private static String hashPassword(String password) {
        // A simple hash function (not suitable for production use)
        return Integer.toHexString(password.hashCode());
    }

    public static void main(String[] args) {
        System.out.println(signup("user1", "pass123")); // true
        System.out.println(signup("user2", "123pass")); // true
        System.out.println(signup("user1", "newpass")); // false
        System.out.println(signup("user3", "mySecret")); // true
        System.out.println(signup("user4", "anotherPass")); // true
    }
}