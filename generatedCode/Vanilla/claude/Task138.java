package Vanilla.claude;

class Permission {
    private String name;
    private boolean read;
    private boolean write;
    private boolean execute;
    
    public Permission(String name) {
        this.name = name;
        this.read = false;
        this.write = false; 
        this.execute = false;
    }
    
    public void grantRead() { this.read = true; }
    public void grantWrite() { this.write = true; }
    public void grantExecute() { this.execute = true; }
    
    public void revokeRead() { this.read = false; }
    public void revokeWrite() { this.write = false; }
    public void revokeExecute() { this.execute = false; }
    
    public boolean canRead() { return read; }
    public boolean canWrite() { return write; }
    public boolean canExecute() { return execute; }
    public String getName() { return name; }
}

class User {
    private String username;
    private Permission permission;
    
    public User(String username) {
        this.username = username;
        this.permission = new Permission(username);
    }
    
    public String getUsername() { return username; }
    public Permission getPermission() { return permission; }
}

public class Task138 {
    public static void managePermission(User user, boolean read, boolean write, boolean execute) {
        Permission perm = user.getPermission();
        
        if(read) perm.grantRead();
        else perm.revokeRead();
        
        if(write) perm.grantWrite();
        else perm.revokeWrite();
        
        if(execute) perm.grantExecute();
        else perm.revokeExecute();
    }
    
    public static void main(String[] args) {
        // Test cases
        User user1 = new User("admin");
        managePermission(user1, true, true, true);
        System.out.println("User: " + user1.getUsername());
        System.out.println("Read: " + user1.getPermission().canRead());
        System.out.println("Write: " + user1.getPermission().canWrite());
        System.out.println("Execute: " + user1.getPermission().canExecute());
        
        User user2 = new User("guest");
        managePermission(user2, true, false, false);
        System.out.println("\\nUser: " + user2.getUsername());
        System.out.println("Read: " + user2.getPermission().canRead());
        System.out.println("Write: " + user2.getPermission().canWrite());
        System.out.println("Execute: " + user2.getPermission().canExecute());
        
        User user3 = new User("developer");
        managePermission(user3, true, true, false);
        System.out.println("\\nUser: " + user3.getUsername());
        System.out.println("Read: " + user3.getPermission().canRead());
        System.out.println("Write: " + user3.getPermission().canWrite());
        System.out.println("Execute: " + user3.getPermission().canExecute());
        
        User user4 = new User("viewer");
        managePermission(user4, true, false, false);
        System.out.println("\\nUser: " + user4.getUsername());
        System.out.println("Read: " + user4.getPermission().canRead());
        System.out.println("Write: " + user4.getPermission().canWrite());
        System.out.println("Execute: " + user4.getPermission().canExecute());
        
        User user5 = new User("root");
        managePermission(user5, true, true, true);
        System.out.println("\\nUser: " + user5.getUsername());
        System.out.println("Read: " + user5.getPermission().canRead());
        System.out.println("Write: " + user5.getPermission().canWrite());
        System.out.println("Execute: " + user5.getPermission().canExecute());
    }
}
