package CoT.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task116 {

    public static void changePassword(String username, String newPassword) throws IOException, InterruptedException {
        // Execute privileged operation (changing password)
        ProcessBuilder pb = new ProcessBuilder("passwd", username);
        Process p = pb.start();

        // Provide the new password as input
        p.getOutputStream().write((newPassword + "\n").getBytes());
        p.getOutputStream().write((newPassword + "\n").getBytes());
        p.getOutputStream().flush();
        p.waitFor();

       
    }


    public static void main(String[] args) {
         // Test cases (replace with actual usernames and passwords)
        try {
            changePassword("testuser", "new_password1");
            changePassword("testuser2", "new_password2");
            changePassword("testuser3", "new_password3");
            changePassword("testuser4", "new_password4");
            changePassword("testuser5", "new_password5");
        } catch (IOException | InterruptedException e) {
            System.err.println("Error changing password: " + e.getMessage());
        }

    }
}