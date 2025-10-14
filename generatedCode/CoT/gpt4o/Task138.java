package CoT.openai;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Task138 {
    private HashMap<String, Set<String>> userPermissions;

    public Task138() {
        userPermissions = new HashMap<>();
    }

    public void addUser(String user) {
        userPermissions.putIfAbsent(user, new HashSet<>());
    }

    public void grantPermission(String user, String permission) {
        if (userPermissions.containsKey(user)) {
            userPermissions.get(user).add(permission);
        }
    }

    public void revokePermission(String user, String permission) {
        if (userPermissions.containsKey(user)) {
            userPermissions.get(user).remove(permission);
        }
    }

    public boolean checkPermission(String user, String permission) {
        return userPermissions.containsKey(user) && userPermissions.get(user).contains(permission);
    }

    public static void main(String[] args) {
        Task138 task = new Task138();
        
        task.addUser("alice");
        task.addUser("bob");
        
        task.grantPermission("alice", "read");
        task.grantPermission("alice", "write");
        task.grantPermission("bob", "read");
        
        System.out.println(task.checkPermission("alice", "read")); // true
        System.out.println(task.checkPermission("alice", "write")); // true
        System.out.println(task.checkPermission("bob", "write")); // false
        
        task.revokePermission("alice", "write");
        
        System.out.println(task.checkPermission("alice", "write")); // false
    }
}