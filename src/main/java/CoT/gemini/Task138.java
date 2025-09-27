package CoT.gemini;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task138 {

    private Map<String, List<String>> userPermissions;

    public Task138() {
        userPermissions = new HashMap<>();
    }

    public void addUser(String user) {
        if (!userPermissions.containsKey(user)) {
            userPermissions.put(user, new ArrayList<>());
        }
    }

    public void addPermission(String user, String permission) {
        if (!userPermissions.containsKey(user)) {
            addUser(user);
        }
        userPermissions.get(user).add(permission);
    }

    public void removePermission(String user, String permission) {
        if (userPermissions.containsKey(user)) {
            userPermissions.get(user).remove(permission);
        }
    }

    public boolean hasPermission(String user, String permission) {
        return userPermissions.containsKey(user) && userPermissions.get(user).contains(permission);
    }

    public List<String> getUserPermissions(String user) {
        return userPermissions.getOrDefault(user, new ArrayList<>());
    }


    public static void main(String[] args) {
        Task138 permissionManager = new Task138();

        // Test cases
        permissionManager.addUser("alice");
        permissionManager.addPermission("alice", "read");
        permissionManager.addPermission("alice", "write");
        System.out.println(permissionManager.hasPermission("alice", "read")); // true
        System.out.println(permissionManager.hasPermission("alice", "execute")); // false

        permissionManager.addUser("bob");
        permissionManager.addPermission("bob", "execute");
        System.out.println(permissionManager.getUserPermissions("bob")); // [execute]

        permissionManager.removePermission("alice", "write");
        System.out.println(permissionManager.getUserPermissions("alice")); // [read]

        System.out.println(permissionManager.hasPermission("charlie", "read")); // false


        permissionManager.addUser("eve");
        permissionManager.addPermission("eve","read");
        permissionManager.addPermission("eve","write");
        permissionManager.removePermission("eve", "write");
        System.out.println(permissionManager.getUserPermissions("eve")); //[read]


    }
}