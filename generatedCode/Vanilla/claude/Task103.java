package Vanilla.claude;

public class Task103 {
    public static boolean checkPasswordStrength(String password) {
        if (password.length() < 8)
            return false;
            
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c))
                hasUpper = true;
            else if (Character.isLowerCase(c))
                hasLower = true;
            else if (Character.isDigit(c))
                hasDigit = true;
        }
        
        return hasUpper && hasLower && hasDigit;
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] passwords = {
            "Abcd123", // false - too short
            "abcdefgh", // false - no uppercase and digit
            "ABCDEFGH", // false - no lowercase and digit
            "abcdEFGH", // false - no digit
            "Abcdefg1" // true - meets all criteria
        };
        
        for (String password : passwords) {
            System.out.println("Password: " + password + " is " + 
                (checkPasswordStrength(password) ? "valid" : "invalid"));
        }
    }
}
