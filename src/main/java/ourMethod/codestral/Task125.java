package ourMethod.codestral;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task125 {
    private static Map<String, String> resources = new HashMap<>();

    static {
        resources.put("resource1", "Resource 1 Data");
        resources.put("resource2", "Resource 2 Data");
        resources.put("resource3", "Resource 3 Data");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the resource name: ");
        String resourceName = scanner.nextLine();
        accessResource(resourceName);
    }

    public static void accessResource(String resourceName) {
        if (resources.containsKey(resourceName)) {
            System.out.println("Access granted. Resource data: " + resources.get(resourceName));
        } else {
            System.out.println("Access denied. Resource not found.");
        }
    }
}