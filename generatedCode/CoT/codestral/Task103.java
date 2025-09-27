package CoT.codestral;
public class Task103 {
    public static boolean isStrongPassword(String password) {
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
        System.out.println(isStrongPassword("Abc12345")); // true
        System.out.println(isStrongPassword("abc12345")); // false
        System.out.println(isStrongPassword("ABCdefgh")); // false
        System.out.println(isStrongPassword("ABC12345")); // true
        System.out.println(isStrongPassword("abcdefgh")); // false
    }
}