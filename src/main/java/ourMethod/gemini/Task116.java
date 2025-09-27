package ourMethod.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task116 {

    public static void changePassword(String username, String newPassword) throws IOException, InterruptedException {
        // Execute privileged operation
        ProcessBuilder pb = new ProcessBuilder("passwd", username);
        Process p = pb.start();

        // Provide new password
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        p.getOutputStream().write((newPassword + "\n").getBytes());
        p.getOutputStream().write((newPassword + "\n").getBytes());
        p.getOutputStream().flush();


        // Wait for process to finish
        int exitCode = p.waitFor();

        if (exitCode == 0) {
            System.out.println("Password changed successfully.");
        } else {
            System.err.println("Password change failed. Exit code: " + exitCode);
            // Handle error appropriately, e.g., log or throw exception
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {

        // Test cases
        changePassword("testuser1", "new_password1");
        changePassword("testuser2", "new_password2");
        changePassword("testuser3", "new_password3");
        changePassword("testuser4", "new_password4");
        changePassword("testuser5", "new_password5");

        System.out.println("All test cases completed.");


    }
}