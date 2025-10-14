package Vanilla.openai;
public class Task122 {
    private Map<String, String> users;

    public Task122() {
        users = new HashMap<>();
    }

    public boolean signup(String username, String password) {
        if (users.containsKey(username)) {
            return false; // Username already exists
        }
        users.put(username, password);
        return true;
    }

    public static void main(String[] args) {
        Task122 task = new Task122();

        // Test cases
        System.out.println(task.signup("user1", "pass1")); // true
        System.out.println(task.signup("user2", "pass2")); // true
        System.out.println(task.signup("user1", "pass3")); // false
        System.out.println(task.signup("user3", "pass4")); // true
        System.out.println(task.signup("user2", "pass5")); // false
    }
}