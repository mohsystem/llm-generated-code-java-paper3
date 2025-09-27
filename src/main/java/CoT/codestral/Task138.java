package CoT.codestral;
import java.util.HashSet;
import java.util.Set;

public class Task138 {
    private static class User {
        String username;
        Set<String> permissions;

        public User(String username) {
            this.username = username;
            this.permissions = new HashSet<>();
        }

        public void grantPermission(String permission) {
            permissions.add(permission);
        }

        public void revokePermission(String permission) {
            permissions.remove(permission);
        }

        public boolean hasPermission(String permission) {
            return permissions.contains(permission);
        }
    }

    public static void main(String[] args) {
        User user = new User("JohnDoe");
        user.grantPermission("READ");
        user.grantPermission("WRITE");
        System.out.println(user.hasPermission("READ"));  // Outputs: true
        user.revokePermission("READ");
        System.out.println(user.hasPermission("READ"));  // Outputs: false
    }
}