package Vanilla.claude;

class Task136 {
    public static boolean authenticate(String username, String password) {
        // Hardcoded credentials for demo
        String[][] validUsers = {
            {"admin", "admin123"},
            {"user1", "pass123"},
            {"john", "doe123"},
            {"test", "test123"},
            {"demo", "demo123"}
        };
        
        for(String[] user : validUsers) {
            if(user[0].equals(username) && user[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(authenticate("admin", "admin123")); // true
        System.out.println(authenticate("user1", "pass123")); // true
        System.out.println(authenticate("john", "wrong")); // false
        System.out.println(authenticate("invalid", "test123")); // false
        System.out.println(authenticate("demo", "demo123")); // true
    }
}
