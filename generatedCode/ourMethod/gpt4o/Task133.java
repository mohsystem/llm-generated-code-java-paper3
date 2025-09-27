package ourMethod.gpt4o;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Task133 {
    private HashMap<String, String> users = new HashMap<>();

    public Task133() {
        // Sample users
        users.put("user1", "OldPassword123!");
        users.put("user2", "OldPassword456!");
    }

    public boolean resetPassword(String username, String oldPassword, String newPassword) {
        if (!users.containsKey(username)) {
            return false; // User not found
        }
        if (!users.get(username).equals(oldPassword)) {
            return false; // Old password doesn't match
        }
        if (!isValidPassword(newPassword)) {
            return false; // New password doesn't meet criteria
        }
        users.put(username, newPassword);
        return true;
    }

    private boolean isValidPassword(String password) {
        // Password must be at least 8 characters long, contain one digit, one uppercase letter, one lowercase letter, and one special character
        return password.length() >= 8 &&
               Pattern.compile("[0-9]").matcher(password).find() &&
               Pattern.compile("[A-Z]").matcher(password).find() &&
               Pattern.compile("[a-z]").matcher(password).find() &&
               Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
    }

    public static void main(String[] args) {
        Task133 task = new Task133();
        System.out.println(task.resetPassword("user1", "OldPassword123!", "NewPassword123!")); // true
        System.out.println(task.resetPassword("user2", "WrongPassword!", "NewPassword456!")); // false
        System.out.println(task.resetPassword("user1", "OldPassword123!", "weak")); // false
        System.out.println(task.resetPassword("user3", "OldPassword789!", "StrongPass1!")); // false
        System.out.println(task.resetPassword("user2", "OldPassword456!", "StrongPass2!")); // true
    }
}