package CoT.claude;

public class Task133 {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 20;
    
    public static boolean resetPassword(String oldPassword, String newPassword) {
        // Validate inputs
        if (oldPassword == null || newPassword == null) {
            return false;
        }
        
        // Check password length
        if (newPassword.length() < MIN_LENGTH || newPassword.length() > MAX_LENGTH) {
            return false;
        }
        
        // Check password complexity
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        for (char c : newPassword.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if ("!@#$%^&*()_+-=[]{}|;:,.<>?".indexOf(c) >= 0) hasSpecial = true;
        }
        
        if (!(hasUpper && hasLower && hasDigit && hasSpecial)) {
            return false;
        }
        
        // Check if new password is same as old
        if (newPassword.equals(oldPassword)) {
            return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(resetPassword("OldPass123!", "NewPass123!")); // true
        System.out.println(resetPassword("OldPass123!", "weakpassword")); // false (no upper/special/digit)
        System.out.println(resetPassword("OldPass123!", "Short1!")); // false (too short)
        System.out.println(resetPassword("OldPass123!", "OldPass123!")); // false (same as old)
        System.out.println(resetPassword("OldPass123!", "StrongPass123!@")); // true
    }
}
