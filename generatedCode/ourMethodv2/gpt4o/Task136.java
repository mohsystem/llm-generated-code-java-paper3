package ourMethodv2.gpt4o;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task136 {
    private Map<String, String> users = new HashMap<>();
    
    public Task136() {
        // Hash passwords with salts in real scenarios
        users.put("user1", hashPassword("password1"));
        users.put("user2", hashPassword("password2"));
    }
    
    private String hashPassword(String password) {
        // Simple hash example (not secure)
        return Integer.toHexString(password.hashCode());
    }

    public boolean authenticate(String username, String password) {
        if (users.containsKey(username)) {
            String hashedPassword = hashPassword(password);
            return users.get(username).equals(hashedPassword);
        }
        return false;
    }

    public static void main(String[] args) {
        Task136 auth = new Task136();
        Scanner scanner = new Scanner(System.in);

        String[][] testCases = {
            {"user1", "password1"},
            {"user1", "wrongpassword"},
            {"user2", "password2"},
            {"user2", "wrongpassword"},
            {"user3", "password3"}
        };

        for (String[] testCase : testCases) {
            String username = testCase[0];
            String password = testCase[1];
            System.out.println("Authenticating " + username + ": " + auth.authenticate(username, password));
        }
        
        scanner.close();
    }
}