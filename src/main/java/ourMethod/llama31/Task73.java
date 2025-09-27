package ourMethod.llama31;
public class Task73 {
    public static boolean isValidPassword(String password) {
        if (password.length() < 6 || password.length() > 20) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    public static void main(String[] args) {
        String[] testPasswords = {"Geek12#", "asd123", "Password123!", "P@ssw0rd", "Invalid"};
        for (String password : testPasswords) {
            if (isValidPassword(password)) {
                System.out.println(password + " - Valid Password");
            } else {
                System.out.println(password + " - Invalid Password");
            }
        }
    }
}