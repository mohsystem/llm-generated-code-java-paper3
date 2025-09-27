package ZeroShot.llama31;
import org.mindrot.jbcrypt.BCrypt;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task102 {
    private Map<String, String> users = new HashMap<>();

    //todo incompatible types: unexpected return value
//    public void hashPassword(String password) {
    public String hashPassword(String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashedPassword;
    }

    public void updatePassword(String username, String newPassword) {
        if (users.containsKey(username)) {
            users.put(username, BCrypt.hashpw(newPassword, BCrypt.gensalt()));
            System.out.println("Password updated for " + username);
        } else {
            System.out.println("User " + username + " does not exist");
        }
    }

    public static void main(String[] args) {
        Task102 task = new Task102();
        Scanner scanner = new Scanner(System.in);

        // Test cases
        String[] usernames = {"user1", "user2", "user3", "user4", "user5"};
        String[] passwords = {"password1", "password2", "password3", "password4", "password5"};

        for (int i = 0; i < usernames.length; i++) {
            task.users.put(usernames[i], BCrypt.hashpw(passwords[i], BCrypt.gensalt()));
        }

        for (String username : usernames) {
            System.out.print("Enter new password for " + username + ": ");
            String newPassword = scanner.nextLine();
            task.updatePassword(username, newPassword);
        }
    }
}