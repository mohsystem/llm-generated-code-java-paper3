package ourMethod.gemini;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task138 {

    private Map<String, List<String>> userPermissions;

    public Task138() {
        userPermissions = new HashMap<>();
    }

    public void addUser(String username) {
        if (!userPermissions.containsKey(username)) {
            userPermissions.put(username, new ArrayList<>());
        }
    }

    public void addPermission(String username, String permission) {
        if (userPermissions.containsKey(username)) {
            userPermissions.get(username).add(permission);
        }
    }


    public void removePermission(String username, String permission) {
        if (userPermissions.containsKey(username)) {
            userPermissions.get(username).remove(permission);
        }
    }

    public boolean hasPermission(String username, String permission) {
        if (userPermissions.containsKey(username)) {
            return userPermissions.get(username).contains(permission);
        }
        return false;
    }

    public List<String> getUserPermissions(String username) {
         return userPermissions.getOrDefault(username, new ArrayList<>());
    }



    public static void main(String[] args) {
        Task138 permissionManager = new Task138();

        // Test cases
        permissionManager.addUser("john");
        permissionManager.addPermission("john", "read");
        permissionManager.addPermission("john", "write");
        System.out.println("john has read permission: " + permissionManager.hasPermission("john", "read")); // Expected: true
        System.out.println("john has execute permission: " + permissionManager.hasPermission("john", "execute")); // Expected: false
        permissionManager.removePermission("john", "write");
        System.out.println("john has write permission: " + permissionManager.hasPermission("john", "write")); // Expected: false

        permissionManager.addUser("jane");
        permissionManager.addPermission("jane", "read");
        System.out.println("jane's permissions: " + permissionManager.getUserPermissions("jane")); // Expected: [read]


        permissionManager.addUser("peter");
        System.out.println("peter's permissions: " + permissionManager.getUserPermissions("peter")); // Expected: []
        System.out.println("unknown user has admin permission: " + permissionManager.hasPermission("unknown", "admin")); // Expected: false


        permissionManager.addPermission("john", "execute");
        permissionManager.addPermission("jane", "write");
        System.out.println("john's permissions: " + permissionManager.getUserPermissions("john")); // Expected: [read, execute]
        System.out.println("jane's permissions: " + permissionManager.getUserPermissions("jane")); // Expected: [read, write]

    }
}