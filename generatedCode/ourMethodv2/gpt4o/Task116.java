package ourMethodv2.gpt4o;
import java.io.Console;

public class Task116 {
    public static void main(String[] args) {
        Task116 task = new Task116();
        System.out.println(task.changePassword("user1", "newPassword"));
        System.out.println(task.changePassword("user2", "newPassword"));
        System.out.println(task.changePassword("admin", "adminPass"));
        System.out.println(task.changePassword("guest", "guestPass"));
        System.out.println(task.changePassword("test", "testPass"));
    }
    
    public boolean changePassword(String username, String newPassword) {
        if (isValidInput(username, newPassword)) {
            System.out.println("Password for user " + username + " has been changed.");
            dropPrivileges();
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidInput(String username, String password) {
        return username != null && !username.isEmpty() && password != null && !password.isEmpty();
    }

    private void dropPrivileges() {
        System.out.println("Privileges dropped.");
    }
}