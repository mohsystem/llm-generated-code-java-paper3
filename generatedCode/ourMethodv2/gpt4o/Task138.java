package ourMethodv2.gpt4o;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Task138 {
    private Map<String, Set<String>> userPermissions = new HashMap<>();

    public void addUser(String username) {
        if (!userPermissions.containsKey(username)) {
            userPermissions.put(username, new HashSet<>());
        }
    }

    public void grantPermission(String username, String permission) {
        if (userPermissions.containsKey(username)) {
            userPermissions.get(username).add(permission);
        }
    }

    public void revokePermission(String username, String permission) {
        if (userPermissions.containsKey(username)) {
            userPermissions.get(username).remove(permission);
        }
    }

    public boolean hasPermission(String username, String permission) {
        return userPermissions.containsKey(username) && userPermissions.get(username).contains(permission);
    }

    public static void main(String[] args) {
        Task138 manager = new Task138();
        manager.addUser("Alice");
        manager.grantPermission("Alice", "read");
        manager.grantPermission("Alice", "write");
        System.out.println(manager.hasPermission("Alice", "read")); // true
        System.out.println(manager.hasPermission("Alice", "write")); // true
        manager.revokePermission("Alice", "write");
        System.out.println(manager.hasPermission("Alice", "write")); // false
        System.out.println(manager.hasPermission("Bob", "read")); // false
    }
}