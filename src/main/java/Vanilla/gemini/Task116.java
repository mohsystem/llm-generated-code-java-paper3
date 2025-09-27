package Vanilla.gemini;
import java.io.*;

public class Task116 {

    public static void changePassword(String username, String newPassword) throws IOException, InterruptedException {
        // Execute the password change command as root/administrator
        ProcessBuilder pb = new ProcessBuilder("passwd", username); // passwd is common *nix tool. Adapt if necessary.
        Process p = pb.start();

        // Provide the new password to the process
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));

        // Wait for prompt & write new password twice.  Error handling omitted for brevity.
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.toLowerCase().contains("password")) {
                writer.write(newPassword + "\n");
                writer.flush();
                writer.write(newPassword + "\n");  // Repeat for confirmation
                writer.flush();
                break;
            }
        }
        p.waitFor();


        //Immediately drop privileges (example: setuid to a non-privileged user) - Implementation Specific
        // This is highly system-dependent and might require JNI/JNA or a helper script
        // Here's a placeholder,  replace with your OS-specific privilege dropping mechanism:
        try {
            // Example (POSIX systems - needs a helper program or JNI/JNA):
            Runtime.getRuntime().exec("sudo -u unprivileged_user /bin/bash"); // Example
            System.exit(0); // Terminate current privileged process
        } catch (IOException e) {
            System.err.println("Failed to drop privileges: " + e.getMessage());
        }
    }



    public static void main(String[] args) throws IOException, InterruptedException {
        // Test cases (replace with actual usernames/passwords - and ensure the 'unprivileged_user' exists):
        changePassword("testuser1", "new_password1");
        changePassword("testuser2", "new_password2");
        changePassword("testuser3", "new_password3");
        changePassword("testuser4", "new_password4");
        changePassword("testuser5", "new_password5");

    }
}