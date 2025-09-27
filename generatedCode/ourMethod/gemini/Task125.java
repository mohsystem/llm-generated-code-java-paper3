package ourMethod.gemini;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task125 {

    private static final Map<String, String> resources = new HashMap<>();

    public static String getResource(String resourceName) {
        if (resourceName == null || resourceName.isEmpty()) {
            return "Invalid resource name.";
        }

        if (!resources.containsKey(resourceName)) {
            return "Resource not found.";
        }
        return resources.get(resourceName);

    }

    public static void main(String[] args) {
        resources.put("resource1", "Content of resource 1");
        resources.put("resource2", "Content of resource 2");
        resources.put("resource3", "Content of resource 3");


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter resource name:");
        String resourceName = scanner.nextLine();

        String resourceContent = getResource(resourceName);
        System.out.println(resourceContent);


        // Test cases
        System.out.println(getResource("resource1")); // Expected: Content of resource 1
        System.out.println(getResource("resource4")); // Expected: Resource not found.
        System.out.println(getResource("")); // Expected: Invalid resource name.
        System.out.println(getResource(null)); // Expected: Invalid resource name.
        System.out.println(getResource("resource2")); // Expected: Content of resource 2


        scanner.close();

    }
}