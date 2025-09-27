package ourMethod.gpt4o;
public class Task73 {

    public static boolean isValidAdminPassword(String password) {
        // Password policy:
        // Minimum 8 characters, at least one uppercase letter,
        // one lowercase letter, one number, and one special character
        if (password == null) return false;
        if (password.length() < 8) return false;
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public static void main(String[] args) {
        System.out.println(isValidAdminPassword("Admin123!")); // true
        System.out.println(isValidAdminPassword("admin123"));  // false
        System.out.println(isValidAdminPassword("ADMIN123!")); // false
        System.out.println(isValidAdminPassword("Admin!"));    // false
        System.out.println(isValidAdminPassword("Admin1234")); // false
    }
}