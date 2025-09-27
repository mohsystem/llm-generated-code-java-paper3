package Vanilla.gpt4o;
import java.util.HashMap;
import java.util.Map;

public class Task125 {

    private Map<String, String> resources = new HashMap<>();

    public Task125() {
        // Initializing some resources
        resources.put("user1", "Resource 1");
        resources.put("user2", "Resource 2");
        resources.put("user3", "Resource 3");
    }

    public String accessResource(String userId) {
        return resources.getOrDefault(userId, "Access Denied");
    }

    public static void main(String[] args) {
        Task125 task = new Task125();
        
        System.out.println(task.accessResource("user1")); // Should print Resource 1
        System.out.println(task.accessResource("user2")); // Should print Resource 2
        System.out.println(task.accessResource("user3")); // Should print Resource 3
        System.out.println(task.accessResource("user4")); // Should print Access Denied
        System.out.println(task.accessResource("admin")); // Should print Access Denied
    }
}