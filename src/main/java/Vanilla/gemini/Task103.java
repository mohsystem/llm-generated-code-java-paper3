package Vanilla.gemini;
class Task103 {
    public boolean isStrongPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        return hasUppercase && hasLowercase && hasDigit;
    }

    public static void main(String[] args) {
        Task103 task = new Task103();
        System.out.println(task.isStrongPassword("Hello123")); // true
        System.out.println(task.isStrongPassword("hello")); // false
        System.out.println(task.isStrongPassword("HELLO123")); // false
        System.out.println(task.isStrongPassword("helloWORLD")); // false
        System.out.println(task.isStrongPassword("H3ll0")); // false


    }
}