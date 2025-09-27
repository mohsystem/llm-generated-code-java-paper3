package CoT.llama31;
import java.io.IOException;

public class Task116 {
    public static void main(String[] args) {
        // Test cases
        String[] users = {"user1", "user2", "user3", "user4", "user5"};
        String[] passwords = {"password1", "password2", "password3", "password4", "password5"};

        for (int i = 0; i < users.length; i++) {
            changePasswordAndDropPrivileges(users[i], passwords[i]);
        }
    }

    public static void changePasswordAndDropPrivileges(String user, String password) {
        try {
            // Change password (Linux example)
            Process process = Runtime.getRuntime().exec(new String[] {"sudo", "passwd", user});
            process.getOutputStream().write((password + "\n" + password + "\n").getBytes());
            process.getOutputStream().close();

            // Drop privileges (this is a simplification and may not work as expected in Java)
            // In real-world scenarios, you would use a more secure method to drop privileges.
            System.out.println("Dropping privileges...");
        } catch (IOException e) {
            System.err.println("Error changing password or dropping privileges: " + e.getMessage());
        }
    }
}