package CoT.openai;
// Java code to simulate storing user data (e.g., name and email) in a database.
// Due to the complexity of an actual database connection, this code will simulate the storage.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Task49 {
    private static List<Map<String, String>> database = new ArrayList<>();

    public static boolean storeUserData(String name, String email) {
        if (name == null || email == null || name.isEmpty() || email.isEmpty()) {
            return false;
        }
        Map<String, String> userData = new HashMap<>();
        userData.put("name", name);
        userData.put("email", email);
        database.add(userData);
        return true;
    }

    public static void main(String[] args) {
        System.out.println(storeUserData("John Doe", "john@example.com"));
        System.out.println(storeUserData("Jane Doe", "jane@example.com"));
        System.out.println(storeUserData("", "invalid@example.com"));
        System.out.println(storeUserData("Invalid User", ""));
        System.out.println(storeUserData("Alice", "alice@example.com"));
    }
}