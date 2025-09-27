package CoT.llama31;
import java.util.HashMap;
import java.util.Map;

public class Task53 {
    private static Map<String, String> sessions = new HashMap<>();

    public static void main(String[] args) {
        // Test cases
        createUserSession("user1", "password1");
        createUserSession("user2", "password2");
        validateUserSession("user1", "sessionID1");
        terminateUserSession("user1");
        validateUserSession("user1", "sessionID1");
    }

    public static void createUserSession(String username, String password) {
        String sessionID = generateSessionID();
        sessions.put(sessionID, username);
        System.out.println("User session created for " + username + " with session ID: " + sessionID);
    }

    public static void validateUserSession(String username, String sessionID) {
        if (sessions.containsKey(sessionID) && sessions.get(sessionID).equals(username)) {
            System.out.println("User session is valid for " + username);
        } else {
            System.out.println("User session is invalid for " + username);
        }
    }

    public static void terminateUserSession(String username) {
        for (Map.Entry<String, String> entry : sessions.entrySet()) {
            if (entry.getValue().equals(username)) {
                sessions.remove(entry.getKey());
                System.out.println("User session terminated for " + username);
                return;
            }
        }
        System.out.println("No active session found for " + username);
    }

    public static String generateSessionID() {
        // Simplified session ID generation for demonstration purposes
        return "sessionID" + (sessions.size() + 1);
    }
}