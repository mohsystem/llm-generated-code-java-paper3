package ZeroShot.gpt4o;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task138 {
    private Map<String, Set<String>> userPermissions;

    public Task138() {
        userPermissions = new HashMap<>();
    }

    public void addUser(String username) {
        userPermissions.putIfAbsent(username, new HashSet<>());
    }

    public void removeUser(String username) {
        userPermissions.remove(username);
    }

    public void addPermission(String username, String permission) {
        Set<String> permissions = userPermissions.get(username);
        if (permissions != null) {
            permissions.add(permission);
        }
    }

    public void removePermission(String username, String permission) {
        Set<String> permissions = userPermissions.get(username);
        if (permissions != null) {
            permissions.remove(permission);
        }
    }

    public boolean checkPermission(String username, String permission) {
        Set<String> permissions = userPermissions.get(username);
        return permissions != null && permissions.contains(permission);
    }

    public static void main(String[] args) {
        Task138 permissionsManager = new Task138();

        // Test cases
        permissionsManager.addUser("alice");
        permissionsManager.addPermission("alice", "read");
        permissionsManager.addPermission("alice", "write");
        
        permissionsManager.addUser("bob");
        permissionsManager.addPermission("bob", "execute");

        System.out.println(permissionsManager.checkPermission("alice", "read")); // true
        System.out.println(permissionsManager.checkPermission("alice", "execute")); // false
        System.out.println(permissionsManager.checkPermission("bob", "execute")); // true
        System.out.println(permissionsManager.checkPermission("bob", "read")); // false

        permissionsManager.removePermission("alice", "write");
        System.out.println(permissionsManager.checkPermission("alice", "write")); // false
    }
}