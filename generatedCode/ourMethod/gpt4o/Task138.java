package ourMethod.openai;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task138 {

    public static class User {
        private String username;
        private Set<String> permissions;

        public User(String username) {
            this.username = username;
            this.permissions = new HashSet<>();
        }

        public void addPermission(String permission) {
            permissions.add(permission);
        }

        public void removePermission(String permission) {
            permissions.remove(permission);
        }

        public boolean hasPermission(String permission) {
            return permissions.contains(permission);
        }
    }

    private Map<String, User> users;

    public Task138() {
        users = new HashMap<>();
    }

    public void addUser(String username) {
        users.put(username, new User(username));
    }

    public void removeUser(String username) {
        users.remove(username);
    }

    public void grantPermission(String username, String permission) {
        User user = users.get(username);
        if (user != null) {
            user.addPermission(permission);
        }
    }

    public void revokePermission(String username, String permission) {
        User user = users.get(username);
        if (user != null) {
            user.removePermission(permission);
        }
    }

    public boolean checkPermission(String username, String permission) {
        User user = users.get(username);
        return user != null && user.hasPermission(permission);
    }

    public static void main(String[] args) {
        Task138 system = new Task138();
        
        system.addUser("alice");
        system.addUser("bob");

        system.grantPermission("alice", "read");
        system.grantPermission("bob", "write");

        // Test cases
        System.out.println(system.checkPermission("alice", "read")); // true
        System.out.println(system.checkPermission("alice", "write")); // false
        System.out.println(system.checkPermission("bob", "write")); // true
        system.revokePermission("bob", "write");
        System.out.println(system.checkPermission("bob", "write")); // false
        system.removeUser("alice");
        System.out.println(system.checkPermission("alice", "read")); // false
    }
}