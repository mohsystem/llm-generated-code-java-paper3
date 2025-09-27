package CoT.claude;

public class Task138 {
    private static class User {
        private String username;
        private String role;
        private boolean[] permissions;

        public User(String username, String role) {
            this.username = username;
            this.role = role;
            // Initialize default permissions array (read, write, execute)
            this.permissions = new boolean[3];
        }

        public void setPermission(int permissionIndex, boolean value) {
            if (permissionIndex >= 0 && permissionIndex < permissions.length) {
                permissions[permissionIndex] = value;
            }
        }

        public boolean checkPermission(int permissionIndex) {
            if (permissionIndex >= 0 && permissionIndex < permissions.length) {
                return permissions[permissionIndex];
            }
            return false;
        }

        public String getUsername() {
            return username;
        }

        public String getRole() {
            return role;
        }
    }

    private static boolean validatePermission(User user, int permissionIndex) {
        if (user == null) return false;
        return user.checkPermission(permissionIndex);
    }

    public static void main(String[] args) {
        // Test case 1: Create admin user with all permissions
        User admin = new User("admin", "administrator");
        admin.setPermission(0, true); // read
        admin.setPermission(1, true); // write
        admin.setPermission(2, true); // execute
        System.out.println("Admin read permission: " + validatePermission(admin, 0));

        // Test case 2: Create regular user with only read permission
        User user1 = new User("user1", "regular");
        user1.setPermission(0, true); // read only
        System.out.println("User1 read permission: " + validatePermission(user1, 0));
        System.out.println("User1 write permission: " + validatePermission(user1, 1));

        // Test case 3: Test invalid permission index
        User user2 = new User("user2", "regular");
        user2.setPermission(5, true); // invalid index
        System.out.println("User2 invalid permission: " + validatePermission(user2, 5));

        // Test case 4: Test null user
        System.out.println("Null user permission: " + validatePermission(null, 0));

        // Test case 5: Create guest user with no permissions
        User guest = new User("guest", "guest");
        System.out.println("Guest execute permission: " + validatePermission(guest, 2));
    }
}
