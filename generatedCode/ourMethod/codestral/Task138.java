package ourMethod.codestral;
import java.util.HashSet;
import java.util.Set;

public class Task138 {
    public enum Permission {
        READ, WRITE, EXECUTE
    }

    private Set<Permission> permissions;

    public Task138() {
        this.permissions = new HashSet<>();
    }

    public void addPermission(Permission permission) {
        permissions.add(permission);
    }

    public void removePermission(Permission permission) {
        permissions.remove(permission);
    }

    public boolean hasPermission(Permission permission) {
        return permissions.contains(permission);
    }

    public static void main(String[] args) {
        Task138 user = new Task138();
        user.addPermission(Permission.READ);
        System.out.println(user.hasPermission(Permission.READ)); // true
        System.out.println(user.hasPermission(Permission.WRITE)); // false
        user.removePermission(Permission.READ);
        System.out.println(user.hasPermission(Permission.READ)); // false
    }
}