package Vanilla.gemini;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task122 {

    private static Map<String, String> userPasswords = new HashMap<>();

    public static void signup(String username, String password) {
        userPasswords.put(username, password);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        signup("user1", "password123");
        signup("user2", "securepass");
        signup("user3", "mypassword");
        signup("user4", "complexpass");
        signup("user5", "easy123");


        System.out.println("User passwords stored:");
        for (Map.Entry<String, String> entry : userPasswords.entrySet()) {
            System.out.println("Username: " + entry.getKey() + ", Password: " + entry.getValue());
        }
        scanner.close();


    }
}