package ourMethod.codestral;
import java.io.IOException;
import java.util.Scanner;

public class Task116 {
    public static void main(String[] args) {
        performPrivilegedOperation();
        dropPrivileges();
    }

    private static void performPrivilegedOperation() {
        // Pseudo code for changing user password on OS system
        System.out.println("Enter the new password: ");
        Scanner scanner = new Scanner(System.in);
        String newPassword = scanner.nextLine();
        // Perform the operation
    }

    private static void dropPrivileges() {
        // Pseudo code for dropping user privileges
        System.out.println("User privileges dropped.");
    }
}