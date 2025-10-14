package CoT.openai;
public class Task73 {
    public static boolean isValidAdminPassword(String password) {
        if (password == null || password.length() < 8) return false;
        
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if ("!@#$%^&*()-+".indexOf(ch) >= 0) hasSpecial = true;
        }
        
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public static void main(String[] args) {
        System.out.println(isValidAdminPassword("Admin@123")); // true
        System.out.println(isValidAdminPassword("admin123")); // false
        System.out.println(isValidAdminPassword("ADMIN123!")); // false
        System.out.println(isValidAdminPassword("Admin123")); // false
        System.out.println(isValidAdminPassword("Ad@1")); // false
    }
}