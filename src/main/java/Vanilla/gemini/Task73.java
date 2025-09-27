package Vanilla.gemini;
class Task73 {
    public boolean isValidAdminPassword(String password) {
        if (password == null || password.length() < 10) {
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
            } else if ("!@#$%^&*()_+=-`~[]{}|;':\",./<>?".indexOf(c) != -1) {
                hasSpecialChar = true;
            }
        }
        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    public static void main(String[] args) {
        Task73 task73 = new Task73();
        System.out.println(task73.isValidAdminPassword("Admin123!")); //false
        System.out.println(task73.isValidAdminPassword("Admin123!test")); //true
        System.out.println(task73.isValidAdminPassword("short")); //false
        System.out.println(task73.isValidAdminPassword("NoSpecialChars123")); //false
        System.out.println(task73.isValidAdminPassword("ALLUPPERCASE123!")); //false
    }
}