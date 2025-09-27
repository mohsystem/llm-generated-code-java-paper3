package Vanilla.gemini;
public class Task138 {

    public static boolean hasPermission(String user, String permission) {
        // Replace with your permission logic
        if (user.equals("admin")) {
            return true;
        } else if (user.equals("user1") && permission.equals("read")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPermission("admin", "read")); // true
        System.out.println(hasPermission("admin", "write")); // true
        System.out.println(hasPermission("user1", "read")); // true
        System.out.println(hasPermission("user1", "write")); // false
        System.out.println(hasPermission("user2", "read")); // false
    }
}