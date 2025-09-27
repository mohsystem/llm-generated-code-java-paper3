package CoT.codestral;
public class Task73 {
    public static boolean isValidPassword(String password) {
        // Length check
        if (password.length() < 8) {
            return false;
        }

        // Contains at least one uppercase letter, one lowercase letter, one number, and one special character
        if (!password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*")
                || !password.matches(".*\\d.*") || !password.matches(".*[!@#$%^&*()].*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("Admin@123")); // true
        System.out.println(isValidPassword("admin123")); // false
        System.out.println(isValidPassword("Admin123")); // false
        System.out.println(isValidPassword("Admin@")); // false
        System.out.println(isValidPassword("Admin@12345678")); // true
    }
}