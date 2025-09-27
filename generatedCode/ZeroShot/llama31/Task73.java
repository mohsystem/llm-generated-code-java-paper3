package ZeroShot.llama31;
public class Task73 {
    public static boolean isValidPassword(String password) {
        // Check for minimum length of 8 characters
        if (password.length() < 8) {
            return false;
        }
        // Check for at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        // Check for at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        // Check for at least one digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }
        // Check for at least one special character
        if (!password.matches(".*[@#$%^&*()_+={};':\"|,.<>/?].*")) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {"Password123!", "password123", "Password123", "P@ssw0rd", "short"};
        for (String testCase : testCases) {
            System.out.println("Password: " + testCase + " - Valid: " + isValidPassword(testCase));
        }
    }
}