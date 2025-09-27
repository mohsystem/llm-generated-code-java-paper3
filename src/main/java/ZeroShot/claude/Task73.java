package ZeroShot.claude;

public class Task73 {
    public static boolean isValidAdminPassword(String password) {
        if (password == null || password.length() < 12) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        String specialChars = "!@#$%^&*()_+-=[]{}|;:,.<>?";

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (specialChars.indexOf(c) >= 0) hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public static void main(String[] args) {
        // Test cases
        String[] passwords = {
            "Admin@12345678",       // true
            "weakpassword",         // false (no upper, digit, special)
            "Admin12345678",        // false (no special)
            "Admin@pass",           // false (too short)
            "!@#$%^&*()",          // false (no upper, lower, digit)
        };

        for (String password : passwords) {
            System.out.println("Password: " + password + " is valid: " + 
                             isValidAdminPassword(password));
        }
    }
}
