package ourMethod.claude;

public class Task103 {
    public static boolean checkPasswordStrength(String password) {
        if (password == null) {
            return false;
        }
        
        // Check minimum length
        if (password.length() < 8) {
            return false;
        }
        
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        
        // Check each character
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        
        return hasUpperCase && hasLowerCase && hasDigit;
    }

    public static void main(String[] args) {
        // Test cases
        String[] passwords = {
            "Password123",  // Valid
            "password",     // Invalid: no uppercase, no digit
            "12345678",    // Invalid: no letters
            "Pass",        // Invalid: too short
            "PASSword123"  // Valid
        };

        for (String password : passwords) {
            System.out.println("Password: " + password + " is " + 
                (checkPasswordStrength(password) ? "valid" : "invalid"));
        }
    }
}
