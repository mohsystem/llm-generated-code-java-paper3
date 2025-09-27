package CoT.llama31;
public class Task103 {
    public static boolean checkPasswordStrength(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasLower = false, hasUpper = false, hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        return hasLower && hasUpper && hasDigit;
    }

    public static void main(String[] args) {
        String[] testCases = {"Password123", "password123", "PASSWORD123", "P@ssw0rd", "short"};
        for (String testCase : testCases) {
            if (checkPasswordStrength(testCase)) {
                System.out.println("Password is strong: " + testCase);
            } else {
                System.out.println("Password is weak: " + testCase);
            }
        }
    }
}