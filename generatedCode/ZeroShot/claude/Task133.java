package ZeroShot.claude;

import java.security.SecureRandom;
import java.util.regex.Pattern;

public class Task133 {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 20;
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;:,.<>?";
    
    public static String resetPassword(String oldPassword, String newPassword, String confirmPassword) {
        // Check if new password matches confirmation
        if (!newPassword.equals(confirmPassword)) {
            return "New password and confirmation do not match";
        }
        
        // Validate password strength
        if (!isPasswordStrong(newPassword)) {
            return "Password must be 8-20 characters and contain uppercase, lowercase, numbers and special characters";
        }
        
        // Check if new password is same as old
        if (newPassword.equals(oldPassword)) {
            return "New password must be different from old password";
        }
        
        // Password reset successful - in real system would update in database
        return "Password successfully reset";
    }
    
    private static boolean isPasswordStrong(String password) {
        if (password == null || password.length() < MIN_LENGTH || password.length() > MAX_LENGTH) {
            return false;
        }
        
        // Check for uppercase, lowercase, number and special char
        Pattern upperCase = Pattern.compile("[A-Z]");
        Pattern lowerCase = Pattern.compile("[a-z]");
        Pattern number = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile("[" + Pattern.quote(SPECIAL_CHARS) + "]");
        
        return upperCase.matcher(password).find() &&
               lowerCase.matcher(password).find() &&
               number.matcher(password).find() &&
               special.matcher(password).find();
    }
    
    public static String generateTempPassword() {
        SecureRandom random = new SecureRandom();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789" + SPECIAL_CHARS;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 12; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        // Test case 1: Password reset success
        System.out.println(resetPassword("OldPass123!", "NewPass123@", "NewPass123@"));
        
        // Test case 2: Password confirmation mismatch
        System.out.println(resetPassword("OldPass123!", "NewPass123@", "DifferentPass123@"));
        
        // Test case 3: Weak password
        System.out.println(resetPassword("OldPass123!", "weak", "weak"));
        
        // Test case 4: Same as old password
        System.out.println(resetPassword("OldPass123!", "OldPass123!", "OldPass123!"));
        
        // Test case 5: Generate temporary password
        System.out.println("Generated temp password: " + generateTempPassword());
    }
}
