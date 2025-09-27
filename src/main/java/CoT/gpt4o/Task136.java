package CoT.gpt4o;
import java.util.HashMap;
import java.util.Scanner;

public class Task136 {
    private static HashMap<String, String> users = new HashMap<>();

    static {
        // Initialize with some users
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public static boolean authenticate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public static void main(String[] args) {
        String[][] testCases = {
            {"user1", "password1"},
            {"user2", "wrongpassword"},
            {"nonexistent", "password"},
            {"user3", "password3"},
            {"user1", "password123"}
        };

        for (String[] testCase : testCases) {
            System.out.println("Authentication result for " + testCase[0] + ": " + authenticate(testCase[0], testCase[1]));
        }
    }
}