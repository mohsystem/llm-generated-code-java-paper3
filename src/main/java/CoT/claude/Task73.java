package CoT.claude;

public class Task73 {
    public static boolean isValidAdminPassword(String password) {
        if (password == null || password.length() < 12) {
            return false;
        }
        
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        String specialChars = "!@#$%^&*()_+-=[]{}|;:,.<>?";
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpperCase = true;
            else if (Character.isLowerCase(c)) hasLowerCase = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (specialChars.indexOf(c) >= 0) hasSpecial = true;
        }
        
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecial;
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] passwords = {
            "Admin@123456789",  // valid
            "admin123456",      // invalid - no uppercase, special char
            "Admin123456!@#",   // valid
            "Ab1!defghijkl",    // valid
            "shortpwd"          // invalid - too short
        };
        
        for (String pwd : passwords) {
            System.out.println("Password: " + pwd + " is " + 
                             (isValidAdminPassword(pwd) ? "valid" : "invalid"));
        }
    }
}
