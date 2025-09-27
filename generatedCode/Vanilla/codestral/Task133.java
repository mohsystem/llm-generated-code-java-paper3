package Vanilla.codestral;
public class Task133 {
    public static void resetPassword(String currentPassword, String newPassword, String confirmNewPassword) {
        if (newPassword.equals(confirmNewPassword)) {
            // Implement code to reset password here
            System.out.println("Password reset successful.");
        } else {
            System.out.println("New passwords do not match.");
        }
    }

    public static void main(String[] args) {
        resetPassword("oldPass", "newPass", "newPass");
        resetPassword("oldPass", "newPass", "wrongPass");
    }
}