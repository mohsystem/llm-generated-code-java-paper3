package ZeroShot.openai;
import java.util.Scanner;
import java.util.HashMap;

public class Task125 {
    private static HashMap<String, String> resources;

    static {
        resources = new HashMap<>();
        resources.put("admin", "Admin Resource");
        resources.put("user", "User Resource");
        resources.put("guest", "Guest Resource");
    }

    public static String accessResource(String role) {
        return resources.getOrDefault(role, "Access Denied");
    }

    public static void main(String[] args) {
        String[] roles = {"admin", "user", "guest", "invalid", "user"};
        for (String role : roles) {
            System.out.println("Role: " + role + " -> " + accessResource(role));
        }
    }
}