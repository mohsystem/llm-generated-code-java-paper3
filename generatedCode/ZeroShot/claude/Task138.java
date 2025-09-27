package ZeroShot.claude;

class Task138 {
    public static class PermissionManager {
        private static final int READ = 4;
        private static final int WRITE = 2;
        private static final int EXECUTE = 1;
        
        public static boolean checkPermission(int userPermissions, int requiredPermission) {
            return (userPermissions & requiredPermission) == requiredPermission;
        }
        
        public static int grantPermission(int currentPermissions, int newPermission) {
            return currentPermissions | newPermission;
        }
        
        public static int revokePermission(int currentPermissions, int permission) {
            return currentPermissions & ~permission;
        }
        
        public static String getPermissionString(int permissions) {
            StringBuilder result = new StringBuilder();
            result.append((permissions & READ) != 0 ? "r" : "-");
            result.append((permissions & WRITE) != 0 ? "w" : "-");
            result.append((permissions & EXECUTE) != 0 ? "x" : "-");
            return result.toString();
        }
    }

    public static void main(String[] args) {
        // Test case 1: Grant read permission
        int permissions = 0;
        permissions = PermissionManager.grantPermission(permissions, PermissionManager.READ);
        System.out.println("Test 1: " + PermissionManager.getPermissionString(permissions));
        
        // Test case 2: Grant write and execute permissions
        permissions = PermissionManager.grantPermission(permissions, PermissionManager.WRITE | PermissionManager.EXECUTE);
        System.out.println("Test 2: " + PermissionManager.getPermissionString(permissions));
        
        // Test case 3: Check for write permission
        System.out.println("Test 3: Has write permission: " + 
            PermissionManager.checkPermission(permissions, PermissionManager.WRITE));
        
        // Test case 4: Revoke write permission
        permissions = PermissionManager.revokePermission(permissions, PermissionManager.WRITE);
        System.out.println("Test 4: " + PermissionManager.getPermissionString(permissions));
        
        // Test case 5: Check for write permission after revocation
        System.out.println("Test 5: Has write permission: " + 
            PermissionManager.checkPermission(permissions, PermissionManager.WRITE));
    }
}
