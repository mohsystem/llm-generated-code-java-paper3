package Vanilla.codestral;
public class Task73 {
    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digit = false;
        boolean specialChar = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) upperCase = true;
            else if (Character.isLowerCase(ch)) lowerCase = true;
            else if (Character.isDigit(ch)) digit = true;
            else specialChar = true;
        }
        return upperCase && lowerCase && digit && specialChar;
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("Admin123!")); // true
        System.out.println(isValidPassword("admin123!")); // false, no uppercase
        System.out.println(isValidPassword("ADMIN123!")); // false, no lowercase
        System.out.println(isValidPassword("Admin!Admin")); // false, no digit
        System.out.println(isValidPassword("Admin1234")); // false, no special character
    }
}