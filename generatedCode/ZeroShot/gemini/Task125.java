package ZeroShot.gemini;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task125 {

    private static final Map<String, String> resources = new HashMap<>();

    static {
        resources.put("resource1", "Data for resource 1");
        resources.put("resource2", "Data for resource 2");
        resources.put("resource3", "Data for resource 3");
    }

    public static String getResource(String resourceName) {
        if (resources.containsKey(resourceName)) {
            return resources.get(resourceName);
        } else {
            return "Resource not found.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter resource name:");
        String resourceName = scanner.nextLine();

        String resourceData = getResource(resourceName);
        System.out.println(resourceData);


        System.out.println(getResource("resource1"));
        System.out.println(getResource("resource2"));
        System.out.println(getResource("resource4"));
        System.out.println(getResource("resource3"));
        System.out.println(getResource("resource5"));

        scanner.close();
    }
}