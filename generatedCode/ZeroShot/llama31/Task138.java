package ZeroShot.llama31;
public class Task138 {
    public static void main(String[] args) {
        // Test cases
        User user1 = new User("John", "admin");
        User user2 = new User("Jane", "user");

        System.out.println(user1.hasPermission("create")); // true
        System.out.println(user1.hasPermission("read"));   // true
        System.out.println(user1.hasPermission("update"));  // true
        System.out.println(user1.hasPermission("delete"));   // true

        System.out.println(user2.hasPermission("create")); // false
        System.out.println(user2.hasPermission("read"));   // true
        System.out.println(user2.hasPermission("update")); // false
        System.out.println(user2.hasPermission("delete"));  // false
    }

    public static class User {
        private String name;
        private String role;

        public User(String name, String role) {
            this.name = name;
            this.role = role;
        }

        public boolean hasPermission(String permission) {
            switch (role) {
                case "admin":
                    return true;
                case "user":
                    switch (permission) {
                        case "read":
                            return true;
                        default:
                            return false;
                    }
                default:
                    return false;
            }
        }
    }
}