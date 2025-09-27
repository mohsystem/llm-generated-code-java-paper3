package CoT.llama31;
// Java implementation

class User {
    String name;
    String role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }
}

interface PermissionHandler {
    boolean checkPermission(User user, String action);
    void setNextHandler(PermissionHandler nextHandler);
}

class RolePermissionHandler implements PermissionHandler {
    private PermissionHandler nextHandler;

    @Override
    public boolean checkPermission(User user, String action) {
        if (user.role.equals("admin") && action.equals("write")) {
            return true;
        }
        if (nextHandler != null) {
            return nextHandler.checkPermission(user, action);
        }
        return false;
    }

    @Override
    public void setNextHandler(PermissionHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

class ActionPermissionHandler implements PermissionHandler {
    private PermissionHandler nextHandler;

    @Override
    public boolean checkPermission(User user, String action) {
        if (user.role.equals("viewer") && action.equals("read")) {
            return true;
        }
        if (nextHandler != null) {
            return nextHandler.checkPermission(user, action);
        }
        return false;
    }

    @Override
    public void setNextHandler(PermissionHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

public class Task138 {
    public static void main(String[] args) {
        // Setting up the chain of handlers
        RolePermissionHandler roleHandler = new RolePermissionHandler();
        ActionPermissionHandler actionHandler = new ActionPermissionHandler();
        roleHandler.setNextHandler(actionHandler);

        // Test cases
        User adminUser = new User("Admin", "admin");
        User viewerUser = new User("Viewer", "viewer");

        System.out.println("Admin trying to write: " + roleHandler.checkPermission(adminUser, "write"));
        System.out.println("Viewer trying to read: " + roleHandler.checkPermission(viewerUser, "read"));
        System.out.println("Admin trying to read: " + roleHandler.checkPermission(adminUser, "read"));
        System.out.println("Viewer trying to write: " + roleHandler.checkPermission(viewerUser, "write"));
        System.out.println("Admin trying to delete: " + roleHandler.checkPermission(adminUser, "delete"));
    }
}