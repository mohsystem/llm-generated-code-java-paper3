package ZeroShot.gemini;
class Task73 {
    public boolean isValidAdminPassword(String password) {
        if (password == null || password.length() < 12) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialChars.indexOf(c) != -1) {
                hasSpecialChar = true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    public static void main(String[] args) {
        Task73 task = new Task73();
        System.out.println(task.isValidAdminPassword("Short")); // false
        System.out.println(task.isValidAdminPassword("NoSpecialChars123")); // false
        System.out.println(task.isValidAdminPassword("AllLowercase123!")); // false
        System.out.println(task.isValidAdminPassword("ALLUPPERCASE123!")); // false
        System.out.println(task.isValidAdminPassword("ValidPassword123!")); // true
    }
}