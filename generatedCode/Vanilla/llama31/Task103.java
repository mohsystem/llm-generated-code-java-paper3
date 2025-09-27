package Vanilla.llama31;
public class Task103 {
    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;

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
        String[] testCases = {"Password123", "password123", "PASSWORD123", "P@ssw0rd", "Abcdefgh"};
        for (String testCase : testCases) {
            if (isValidPassword(testCase)) {
                System.out.println(testCase + ": Valid Password");
            } else {
                System.out.println(testCase + ": Invalid Password");
            }
        }
    }
}