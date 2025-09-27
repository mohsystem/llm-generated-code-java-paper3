package ZeroShot.gpt4o;
public class Task103 {
    public static boolean isStrongPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUpper = false, hasLower = false, hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
            if (Character.isDigit(c)) hasDigit = true;
        }
        return hasUpper && hasLower && hasDigit;
    }

    public static void main(String[] args) {
        System.out.println(isStrongPassword("Password1")); // true
        System.out.println(isStrongPassword("password1")); // false
        System.out.println(isStrongPassword("PASSWORD1")); // false
        System.out.println(isStrongPassword("Pass1"));     // false
        System.out.println(isStrongPassword("Pass1234"));  // true
    }
}