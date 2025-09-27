package ourMethod.codestral;
import java.util.Scanner;

public class Task133 {
    private static String password = "oldPassword";

    public static void resetPassword(String oldPassword, String newPassword, String confirmNewPassword) {
        if (!newPassword.equals(confirmNewPassword)) {
            System.out.println("New password and confirmation password do not match.");
            return;
        }
        if (!password.equals(oldPassword)) {
            System.out.println("Old password is incorrect.");
            return;
        }
        if (newPassword.equals(oldPassword)) {
            System.out.println("New password cannot be the same as old password.");
            return;
        }
        password = newPassword;
        System.out.println("Password reset successful.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter old password:");
        String oldPassword = scanner.nextLine();
        System.out.println("Enter new password:");
        String newPassword = scanner.nextLine();
        System.out.println("Confirm new password:");
        String confirmNewPassword = scanner.nextLine();
        resetPassword(oldPassword, newPassword, confirmNewPassword);
    }
}