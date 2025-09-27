package CoT.gemini;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task125 {

    private static final Map<String, String> resources = new HashMap<>();

    static {
        resources.put("resource1", "path/to/resource1");
        resources.put("resource2", "path/to/resource2");
        resources.put("resource3", "path/to/resource3");
    }

    public static String getResourcePath(String resourceName) {
        if (resources.containsKey(resourceName)) {
            return resources.get(resourceName);
        } else {
            return null; 
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter resource name: ");
        String resourceName = scanner.nextLine();
        String resourcePath = getResourcePath(resourceName);

        if (resourcePath != null) {
            System.out.println("Path: " + resourcePath);
        } else {
            System.out.println("Resource not found.");
        }

         // Test cases
        System.out.println(getResourcePath("resource1")); // Expected: path/to/resource1
        System.out.println(getResourcePath("resource2")); // Expected: path/to/resource2
        System.out.println(getResourcePath("resource3")); // Expected: path/to/resource3
        System.out.println(getResourcePath("resource4")); // Expected: null
        System.out.println(getResourcePath("resource1.txt")); // Expected: null


    }
}