package Vanilla.codestral;
import java.util.HashSet;
import java.util.Set;

public class Task138 {
    private Set<String> permissions;

    public Task138() {
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

    public static void main(String[] args) {
        Task138 user = new Task138();

        user.grantPermission("READ");
        user.grantPermission("WRITE");

        System.out.println(user.hasPermission("READ")); // true
        System.out.println(user.hasPermission("EXECUTE")); // false

        user.revokePermission("READ");

        System.out.println(user.hasPermission("READ")); // false
    }
}