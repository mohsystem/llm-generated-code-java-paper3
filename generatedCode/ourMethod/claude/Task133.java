package ourMethod.claude;

public class Task133 {
    private static final int MAX_ATTEMPTS = 3;
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static int attemptCount = 0;
    
    // Simulated user database - in real system use proper secure database
    private static String currentPasswordHash = "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8"; // password
    
    public static boolean resetPassword(String currentPassword, String newPassword) {
        try {
            // Check attempt count to prevent brute force
            if (attemptCount >= MAX_ATTEMPTS) {
                throw new SecurityException("Account locked due to too many attempts");
            }
            
            // Validate inputs
            if (currentPassword == null || newPassword == null) {
                throw new IllegalArgumentException("Passwords cannot be null");
            }
            
            // Validate current password
            String currentHash = hashPassword(currentPassword);
            if (!currentHash.equals(currentPasswordHash)) {
                attemptCount++;
                throw new SecurityException("Invalid current password");
            }
            
            // Validate new password requirements
            if (!isPasswordValid(newPassword)) {
                throw new IllegalArgumentException("New password does not meet requirements");
            }
            
            // Update password
            currentPasswordHash = hashPassword(newPassword);
            attemptCount = 0;
            return true;
            
        } catch (SecurityException | IllegalArgumentException e) {
            // Log error securely - don't expose internal details\n            System.err.println("Password reset failed: " + e.getMessage());\n            return false;\n        } catch (Exception e) {\n            // Log unexpected errors securely\n            System.err.println("Unexpected error during password reset");\n            return false;\n        }\n    }\n    \n    private static boolean isPasswordValid(String password) {\n        if (password.length() < MIN_PASSWORD_LENGTH) return false;\n        \n        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;\n        \n        for (char c : password.toCharArray()) {\n            if (Character.isUpperCase(c)) hasUpper = true;\n            else if (Character.isLowerCase(c)) hasLower = true;\n            else if (Character.isDigit(c)) hasDigit = true;\n            else hasSpecial = true;\n        }\n        \n        return hasUpper && hasLower && hasDigit && hasSpecial;\n    }\n    \n    private static String hashPassword(String password) {\n        try {\n            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");\n            byte[] hash = digest.digest(password.getBytes(java.nio.charset.StandardCharsets.UTF_8));\n            StringBuilder hexString = new StringBuilder();\n            for (byte b : hash) {\n                String hex = Integer.toHexString(0xff & b);\n                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    // Test cases
    public static void main(String[] args) {
        // Test case 1: Successful password reset
        System.out.println("Test 1: " + resetPassword("password", "NewPass123!"));
        
        // Test case 2: Invalid current password
        System.out.println("Test 2: " + resetPassword("wrongpass", "NewPass123!"));
        
        // Test case 3: Invalid new password (too short)
        System.out.println("Test 3: " + resetPassword("password", "Weak1!"));
        
        // Test case 4: Invalid new password (missing requirements)
        System.out.println("Test 4: " + resetPassword("password", "weakpassword"));
        
        // Test case 5: Too many attempts
        System.out.println("Test 5: " + resetPassword("wrongpass", "NewPass123!"));
        System.out.println("Test 5 continued: " + resetPassword("wrongpass", "NewPass123!"));
        System.out.println("Test 5 final: " + resetPassword("wrongpass", "NewPass123!"));
    }
}
