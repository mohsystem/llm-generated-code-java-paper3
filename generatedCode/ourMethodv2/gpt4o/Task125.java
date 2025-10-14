package ourMethodv2.gpt4o;
import java.util.HashMap;
import java.util.Map;

public class Task125 {

    public static String accessResource(String userInput) {
        // Define resources
        Map<String, String> resources = new HashMap<>();
        resources.put("resource1", "Access to Resource 1");
        resources.put("resource2", "Access to Resource 2");
        resources.put("resource3", "Access to Resource 3");

        // Validate and access resource
        if (resources.containsKey(userInput)) {
            return resources.get(userInput);
        } else {
            return "Invalid resource requested.";
        }
    }

    public static void main(String[] args) {
        System.out.println(accessResource("resource1")); // Test case 1
        System.out.println(accessResource("resource2")); // Test case 2
        System.out.println(accessResource("resource3")); // Test case 3
        System.out.println(accessResource("resource4")); // Test case 4
        System.out.println(accessResource(""));          // Test case 5
    }
}