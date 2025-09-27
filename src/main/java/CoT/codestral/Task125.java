package CoT.codestral;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task125 {
    private static Map<String, String> resources = new HashMap<>();

    static {
        resources.put("user1", "Resource1");
        resources.put("user2", "Resource2");
        resources.put("user3", "Resource3");
    }

    public static String getResource(String user) {
        return resources.getOrDefault(user, "Access Denied");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String user = scanner.nextLine();
        String resource = getResource(user);
        System.out.println("User " + user + " has access to: " + resource);
    }
}