package CoT.openai;
public class Task103 {

    public static boolean checkPasswordStrength(String password) {
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
        System.out.println(checkPasswordStrength("Password123")); // true
        System.out.println(checkPasswordStrength("password")); // false
        System.out.println(checkPasswordStrength("PASSWORD123")); // false
        System.out.println(checkPasswordStrength("Pass123")); // false
        System.out.println(checkPasswordStrength("Passw0rd")); // true
    }
}