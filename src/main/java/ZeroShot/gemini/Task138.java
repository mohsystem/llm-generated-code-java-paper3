package ZeroShot.gemini;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Task138 {

    private Map<String, Set<String>> userPermissions;

    public Task138() {
        userPermissions = new HashMap<>();
    }

    public void addUser(String user) {
        if (!userPermissions.containsKey(user)) {
            userPermissions.put(user, new HashSet<>());
        }
    }

    public void removeUser(String user) {
        userPermissions.remove(user);
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


    public static void main(String[] args) {
        Task138 permissionManager = new Task138();

        // Test cases
        permissionManager.addUser("alice");
        permissionManager.addPermission("alice", "read");
        permissionManager.addPermission("alice", "write");
        System.out.println(permissionManager.hasPermission("alice", "read")); // true
        System.out.println(permissionManager.hasPermission("alice", "execute")); // false

        permissionManager.removePermission("alice", "write");
        System.out.println(permissionManager.hasPermission("alice", "write")); // false

        permissionManager.addUser("bob");
        permissionManager.addPermission("bob", "execute");
        System.out.println(permissionManager.hasPermission("bob", "execute")); // true

        permissionManager.removeUser("alice");
        System.out.println(permissionManager.hasPermission("alice", "read")); // false


    }
}