package ourMethodv2.gpt4o;
public class Task73 {
    public static boolean isValidAdminPassword(String password) {
        if (password == null || password.length() < 8) return false;
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (Character.isLowerCase(ch)) hasLower = true;
            if (Character.isDigit(ch)) hasDigit = true;
            if ("!@#$%^&*()-_+=<>?".indexOf(ch) >= 0) hasSpecial = true;
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public static void main(String[] args) {
        System.out.println(isValidAdminPassword("Admin@123")); // true
        System.out.println(isValidAdminPassword("password")); // false
        System.out.println(isValidAdminPassword("Passw0rd")); // false
        System.out.println(isValidAdminPassword("Admin1234")); // false
        System.out.println(isValidAdminPassword("Adm!n123")); // true
    }
}