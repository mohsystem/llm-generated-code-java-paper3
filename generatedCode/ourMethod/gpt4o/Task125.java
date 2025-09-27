package ourMethod.gpt4o;
import java.util.HashMap;
import java.util.Map;

public class Task125 {
    private static Map<String, String> resourceAccess;

    static {
        resourceAccess = new HashMap<>();
        resourceAccess.put("user1", "Resource A");
        resourceAccess.put("user2", "Resource B");
        resourceAccess.put("user3", "Resource C");
        resourceAccess.put("admin", "All Resources");
    }

    public static String getResource(String user) {
        if (user == null || user.isEmpty()) {
            return "Invalid user input.";
        }
        return resourceAccess.getOrDefault(user, "Access Denied");
    }

    public static void main(String[] args) {
        System.out.println(getResource("user1"));
        System.out.println(getResource("user2"));
        System.out.println(getResource("user3"));
        System.out.println(getResource("admin"));
        System.out.println(getResource("unknown"));
    }
}