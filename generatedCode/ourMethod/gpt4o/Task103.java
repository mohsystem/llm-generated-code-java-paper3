package ourMethod.gpt4o;
public class Task103 {

    public static boolean isPasswordStrong(String password) {
        if (password == null || password.length() < 8) return false;

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
            if (Character.isDigit(c)) hasDigit = true;
        }

        return hasUpper && hasLower && hasDigit;
    }

    public static void main(String[] args) {
        System.out.println(isPasswordStrong("Password1")); // true
        System.out.println(isPasswordStrong("password1")); // false
        System.out.println(isPasswordStrong("PASSWORD1")); // false
        System.out.println(isPasswordStrong("Pass1"));     // false
        System.out.println(isPasswordStrong("PassWord1")); // true
    }
}