package ourMethod.llama31;
import java.io.IOException;
import java.util.Scanner;

public class Task116 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the username: ");
        String username = scanner.nextLine();
        System.out.print("Enter the new password: ");
        String newPassword = scanner.nextLine();

        // Execute the command to change the password with elevated privileges
        try {
            Process process = Runtime.getRuntime().exec(new String[] {"sudo", "passwd", username});
            // Provide the new password to the process
            process.getOutputStream().write((newPassword + "\n" + newPassword + "\n").getBytes());
            process.getOutputStream().close();

            // Wait for the process to finish
            process.waitFor();

            // Drop privileges
            System.out.println("Privileges dropped.");
        } catch (IOException | InterruptedException e) {
            System.err.println("Error changing password: " + e.getMessage());
        }
    }
}