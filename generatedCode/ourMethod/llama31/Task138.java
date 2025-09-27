package ourMethod.llama31;
public class Task138 {
    public static void main(String[] args) {
        // Test cases
        User user1 = new User("user1", "admin");
        User user2 = new User("user2", "user");

        System.out.println(user1.hasPermission("create")); // true
        System.out.println(user1.hasPermission("read"));   // true
        System.out.println(user1.hasPermission("update")); // true
        System.out.println(user1.hasPermission("delete")); // true

        System.out.println(user2.hasPermission("create")); // false
        System.out.println(user2.hasPermission("read"));   // true
        System.out.println(user2.hasPermission("update")); // false
        System.out.println(user2.hasPermission("delete")); // false
    }
}

class User {
    private String username;
    private String role;
    private static final Role[] roles = {
        new Role("admin", new String[] {"create", "read", "update", "delete"}),
        new Role("user", new String[] {"read"})
    };

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public boolean hasPermission(String permission) {
        for (Role r : roles) {
            if (r.getName().equals(role)) {
                for (String p : r.getPermissions()) {
                    if (p.equals(permission)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Role {
    private String name;
    private String[] permissions;

    public Role(String name, String[] permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public String[] getPermissions() {
        return permissions;
    }
}