package Vanilla.llama31;
public class Task73 {
    public static boolean isValidPassword(String password) {
        if (password.length() < 10) return false;
        boolean hasUppercase = false, hasNumber = false, hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUppercase = true;
            else if (Character.isDigit(c)) hasNumber = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecialChar = true;
        }
        return hasUppercase && hasNumber && hasSpecialChar;
    }

    public static void main(String[] args) {
        String[] testCases = {"Passw0rd!", "password123", "P@ssw0rd!", "short", "NoSpecialChar123"};
        for (String testCase : testCases) {
            System.out.println("Password: " + testCase + " - Valid: " + isValidPassword(testCase));
        }
    }
}