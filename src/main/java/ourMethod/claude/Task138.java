package ourMethod.claude;

import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Task138 {
    private static class User {
        private final String username;
        private final String passwordHash;
        private Role role;
        
        public User(String username, String password) {
            this.username = username;
            this.passwordHash = hashPassword(password);
            this.role = Role.USER;
        }
        
        private String hashPassword(String password) {
            try {
                return java.security.MessageDigest.getInstance("SHA-256")
                    .digest(password.getBytes())
                    .toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    private static enum Role {
        ADMIN(new String[]{"READ", "WRITE", "DELETE", "MANAGE_USERS"}),
        MANAGER(new String[]{"READ", "WRITE", "DELETE"}),
        USER(new String[]{"READ", "WRITE"});
        
        private final String[] permissions;
        
        Role(String[] permissions) {
            this.permissions = permissions;
        }
        
        public boolean hasPermission(String permission) {
            for(String p : permissions) {
                if(p.equals(permission)) return true;
            }
            return false;
        }
    }
    
    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final Map<String, Object> resources = new ConcurrentHashMap<>();
    
    public boolean createUser(String username, String password) {
        if(username == null || password == null || username.isEmpty() || password.length() < 8) {
            return false;
        }
        return users.putIfAbsent(username, new User(username, password)) == null;
    }
    
    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        if(user == null) return false;
        return user.passwordHash.equals(user.hashPassword(password));
    }
    
    public boolean checkPermission(String username, String permission) {
        User user = users.get(username);
        if(user == null) return false;
        return user.role.hasPermission(permission);
    }
    
    public boolean setRole(String adminUsername, String targetUsername, Role newRole) {
        User admin = users.get(adminUsername);
        if(admin == null || admin.role != Role.ADMIN) return false;
        
        User target = users.get(targetUsername);
        if(target == null) return false;
        
        target.role = newRole;
        return true;
    }
    
    public static void main(String[] args) {
        Task138 manager = new Task138();
        
        // Test case 1: Create users
        System.out.println(manager.createUser("admin", "admin123456")); // true
        System.out.println(manager.createUser("user1", "user123456")); // true
        
        // Test case 2: Authentication
        System.out.println(manager.authenticate("admin", "admin123456")); // true
        System.out.println(manager.authenticate("user1", "wrongpass")); // false
        
        // Test case 3: Permission check
        System.out.println(manager.checkPermission("user1", "READ")); // true
        System.out.println(manager.checkPermission("user1", "MANAGE_USERS")); // false
        
        // Test case 4: Role modification
        System.out.println(manager.setRole("admin", "user1", Role.MANAGER)); // true
        
        // Test case 5: Permission check after role change
        System.out.println(manager.checkPermission("user1", "DELETE")); // true
    }
}
