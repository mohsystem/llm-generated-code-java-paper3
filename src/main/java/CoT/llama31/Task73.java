package CoT.llama31;
// Java code
public class Task73 {
    public static boolean isValidPassword(String password) {
        if (password.length() < 6 || password.length() > 20) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        String specialChars = "!@#$%^&*()_+-={}:<>?,./";
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialChars.indexOf(c) != -1) {
                hasSpecial = true;
            }
        }
        return hasUppercase && hasLowercase && hasDigit && hasSpecial;
    }

    public static void main(String[] args) {
        String[] testCases = {"Geek12#", "asd123", "Password123!", "short", "VeryLongPasswordThatIsNotValidBecauseItIsTooLong"};
        for (String testCase : testCases) {
            if (isValidPassword(testCase)) {
                System.out.println(testCase + " - Valid Password");
            } else {
                System.out.println(testCase + " - Invalid Password");
            }
        }
    }
}