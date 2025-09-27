package ZeroShot.claude;

public class Task103 {
    public static boolean checkPasswordStrength(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        
        return hasUpper && hasLower && hasDigit;
    }

    public static void main(String[] args) {
        String[] testPasswords = {
            "Abcd123!", // valid
            "abcd123", // invalid - no uppercase
            "ABCD123", // invalid - no lowercase
            "Abcdefgh", // invalid - no digit
            "Ab1" // invalid - too short
        };
        
        for (String password : testPasswords) {
            System.out.println("Password: " + password + " is " + 
                (checkPasswordStrength(password) ? "valid" : "invalid"));
        }
    }
}
