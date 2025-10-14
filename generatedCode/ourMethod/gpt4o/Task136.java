package ourMethod.openai;
import java.util.HashMap;
import java.util.Scanner;

public class Task136 {

    private HashMap<String, String> users;

    public Task136() {
        this.users = new HashMap<>();
        this.users.put("user1", "password1");
        this.users.put("user2", "password2");
        this.users.put("user3", "password3");
        this.users.put("user4", "password4");
        this.users.put("user5", "password5");
    }

    public boolean authenticate(String username, String password) {
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public static void main(String[] args) {
        Task136 task = new Task136();
        Scanner scanner = new Scanner(System.in);
        String[][] testCases = {
            {"user1", "password1"},
            {"user2", "wrongpassword"},
            {"user3", "password3"},
            {"invalidUser", "password"},
            {"user4", "password4"}
        };

        for (String[] testCase : testCases) {
            String username = testCase[0];
            String password = testCase[1];
            System.out.println("Authenticating " + username + ": " + task.authenticate(username, password));
        }
        scanner.close();
    }
}