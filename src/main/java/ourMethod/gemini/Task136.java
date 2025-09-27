package ourMethod.gemini;
import java.util.HashMap;
import java.util.Map;

class Task136 {

    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("user1", "password123");
        users.put("user2", "securepass");
        users.put("user3", "anotherpassword");
    }

    public static boolean authenticate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        // Avoid timing attacks by using a constant-time comparison
        String storedPassword = users.get(username);
        if (storedPassword == null) {
            return false;
        }

        return constantTimeEquals(password, storedPassword);

    }


    private static boolean constantTimeEquals(String a, String b) {
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
        System.out.println(authenticate("user1", "password123")); // true
        System.out.println(authenticate("user2", "wrongpass")); // false
        System.out.println(authenticate("user3", "anotherpassword")); // true
        System.out.println(authenticate("nonexistentuser", "password")); // false
        System.out.println(authenticate(null, "password")); // false


    }
}