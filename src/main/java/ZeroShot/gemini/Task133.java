package ZeroShot.gemini;
import java.util.Random;
import java.util.Scanner;

class Task133 {
    public String resetPassword(String currentPassword, String newPassword) {
        if (currentPassword == null || newPassword == null || currentPassword.isEmpty() || newPassword.isEmpty()) {
            return "Error: Passwords cannot be empty.";
        }
        // Add additional password validation checks here (e.g., length, complexity)
        if (newPassword.length() < 8) {
            return "Error: New password must be at least 8 characters long.";
        }

        return "Password reset successful."; // Placeholder for actual password update
    }

    public static void main(String[] args) {
        Task133 passwordReset = new Task133();
        Scanner scanner = new Scanner(System.in);

        System.out.println(passwordReset.resetPassword("oldPassword", "newPassword123"));
        System.out.println(passwordReset.resetPassword("short", "new"));
        System.out.println(passwordReset.resetPassword("", "new"));
        System.out.println(passwordReset.resetPassword(null, "new"));
        System.out.println(passwordReset.resetPassword("current", null));


    }
}