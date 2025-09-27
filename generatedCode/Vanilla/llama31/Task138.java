package Vanilla.llama31;
public class Task138 {
    public static void main(String[] args) {
        UserPrivilegeManager manager = new UserPrivilegeManager();

        // Test cases
        manager.addUser("admin", "administrator");
        manager.addUser("user", "standard");
        manager.addUser("guest", "guest");

        manager.assignPrivilege("administrator", "create", true);
        manager.assignPrivilege("administrator", "read", true);
        manager.assignPrivilege("administrator", "update", true);
        manager.assignPrivilege("administrator", "delete", true);

        manager.assignPrivilege("standard", "read", true);
        manager.assignPrivilege("standard", "update", true);

        manager.assignPrivilege("guest", "read", true);

        System.out.println(manager.checkPrivilege("admin", "create")); // true
        System.out.println(manager.checkPrivilege("user", "create")); // false
        System.out.println(manager.checkPrivilege("guest", "update")); // false
        System.out.println(manager.checkPrivilege("admin", "read")); // true
        System.out.println(manager.checkPrivilege("user", "read")); // true
    }

    public static class UserPrivilegeManager {
        private static final java.util.HashMap<String, String> users = new java.util.HashMap<>();
        private static final java.util.HashMap<String, java.util.HashMap<String, Boolean>> privileges = new java.util.HashMap<>();

        public void addUser(String username, String role) {
            users.put(username, role);
        }

        public void assignPrivilege(String role, String privilege, Boolean allowed) {
            privileges.computeIfAbsent(role, k -> new java.util.HashMap<>()).put(privilege, allowed);
        }

        public Boolean checkPrivilege(String username, String privilege) {
            String role = users.get(username);
            if (role != null) {
                return privileges.getOrDefault(role, new java.util.HashMap<>()).getOrDefault(privilege, false);
            }
            return false;
        }
    }
}