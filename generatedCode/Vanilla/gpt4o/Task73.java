package Vanilla.gpt4o;
public class Task73 {

    public static boolean isValidAdminPassword(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") 
            && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()].*");
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidAdminPassword("Admin123!")); // true
        System.out.println(isValidAdminPassword("admin123"));   // false
        System.out.println(isValidAdminPassword("Admin!"));     // false
        System.out.println(isValidAdminPassword("12345678"));   // false
        System.out.println(isValidAdminPassword("AdminUser1$")); // true
    }
}