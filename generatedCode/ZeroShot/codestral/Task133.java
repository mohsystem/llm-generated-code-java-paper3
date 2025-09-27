package ZeroShot.codestral;
public class Task133 {
    private Map<String, String> users = new HashMap<>();

    public void addUser(String username, String password) {
        users.put(username, password);
    }

    public boolean resetPassword(String username, String oldPassword, String newPassword) {
        if (users.containsKey(username) && users.get(username).equals(oldPassword)) {
            users.put(username, newPassword);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Task133 app = new Task133();
        app.addUser("user1", "pass1");
        System.out.println(app.resetPassword("user1", "pass1", "newPass")); // Should print true
        System.out.println(app.resetPassword("user1", "pass1", "anotherNewPass")); // Should print false
    }
}