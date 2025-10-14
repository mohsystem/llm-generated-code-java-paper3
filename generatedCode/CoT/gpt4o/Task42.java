package CoT.openai;
import java.util.HashMap;
import java.util.Map;

public class Task42 {
    private Map<String, String> userDatabase = new HashMap<>();

    public boolean registerUser(String username, String password) {
        if (userDatabase.containsKey(username)) {
            return false;
        }
        userDatabase.put(username, hashPassword(password));
        return true;
    }

    public boolean authenticateUser(String username, String password) {
        String storedPasswordHash = userDatabase.get(username);
        return storedPasswordHash != null && storedPasswordHash.equals(hashPassword(password));
    }

    private String hashPassword(String password) {
        // Simple hash function for demonstration purposes (not secure for real applications)
        return Integer.toString(password.hashCode());
    }

    public static void main(String[] args) {
        Task42 authSystem = new Task42();
        
        System.out.println(authSystem.registerUser("user1", "password1")); // True
        System.out.println(authSystem.authenticateUser("user1", "password1")); // True
        System.out.println(authSystem.authenticateUser("user1", "wrongpassword")); // False
        System.out.println(authSystem.registerUser("user1", "password1")); // False
        System.out.println(authSystem.authenticateUser("user2", "password2")); // False
    }
}