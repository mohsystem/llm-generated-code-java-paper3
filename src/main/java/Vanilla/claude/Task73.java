package Vanilla.claude;

class Task73 {
    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpperCase = true;
            else if (Character.isLowerCase(c)) hasLowerCase = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if ("!@#$%^&*()_+-=[]{}|;:,.<>?".indexOf(c) != -1) hasSpecialChar = true;
        }
        
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidPassword("Admin@123")); // true
        System.out.println(isValidPassword("password123")); // false (no uppercase, no special char)
        System.out.println(isValidPassword("Pass@")); // false (too short)
        System.out.println(isValidPassword("ADMIN@123")); // false (no lowercase)
        System.out.println(isValidPassword("Admin123456")); // false (no special char)
    }
}
