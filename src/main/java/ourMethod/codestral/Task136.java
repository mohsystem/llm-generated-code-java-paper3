package ourMethod.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task136 {
    private Map<String, String> users = new HashMap<>();

    public Task136() {
        // Populate the users map with some user credentials for testing
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean authenticate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        String storedPassword = users.get(username);
        if (storedPassword == null) {
            return false;
        }

        // Compare the passwords using a secure method
        return secureCompare(password, storedPassword);
    }

    private boolean secureCompare(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            result |= a.charAt(i) ^ b.charAt(i);
        }

        return result == 0;
    }

    public static void main(String[] args) {
        Task136 auth = new Task136();

        // Test cases
        System.out.println(auth.authenticate("user1", "password1")); // Expected: true
        System.out.println(auth.authenticate("user1", "wrong_password")); // Expected: false
        System.out.println(auth.authenticate("nonexistent_user", "password")); // Expected: false
        System.out.println(auth.authenticate(null, "password")); // Expected: false
        System.out.println(auth.authenticate("user1", null)); // Expected: false
    }
}