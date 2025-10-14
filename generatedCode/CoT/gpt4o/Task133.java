package CoT.openai;
import java.util.HashMap;
import java.util.Map;

public class Task133 {
    private Map<String, String> userDatabase = new HashMap<>();

    public Task133() {
        // Initialize with some test users
        userDatabase.put("user1", "oldPassword1");
        userDatabase.put("user2", "oldPassword2");
        userDatabase.put("user3", "oldPassword3");
        userDatabase.put("user4", "oldPassword4");
        userDatabase.put("user5", "oldPassword5");
    }

    public boolean resetPassword(String username, String oldPassword, String newPassword) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(oldPassword)) {
            userDatabase.put(username, newPassword);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Task133 task = new Task133();
        
        System.out.println(task.resetPassword("user1", "oldPassword1", "newPassword1")); // true
        System.out.println(task.resetPassword("user2", "wrongPassword", "newPassword2")); // false
        System.out.println(task.resetPassword("user3", "oldPassword3", "newPassword3")); // true
        System.out.println(task.resetPassword("user4", "oldPassword4", "newPassword4")); // true
        System.out.println(task.resetPassword("user5", "oldPassword5", "newPassword5")); // true
    }
}