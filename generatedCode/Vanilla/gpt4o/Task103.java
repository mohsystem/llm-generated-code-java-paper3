package Vanilla.gpt4o;
public class Task103 {
    public static boolean checkPasswordStrength(String password) {
        if (password.length() < 8) return false;
        boolean hasUpper = false, hasLower = false, hasDigit = false;
        
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (Character.isLowerCase(ch)) hasLower = true;
            if (Character.isDigit(ch)) hasDigit = true;
        }
        
        return hasUpper && hasLower && hasDigit;
    }

    public static void main(String[] args) {
        System.out.println(checkPasswordStrength("Password1")); // true
        System.out.println(checkPasswordStrength("password1")); // false
        System.out.println(checkPasswordStrength("PASSWORD1")); // false
        System.out.println(checkPasswordStrength("Pass1"));     // false
        System.out.println(checkPasswordStrength("PassWord123"));// true
    }
}