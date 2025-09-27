package ourMethod.codestral;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task122 {
    private Map<String, String> users = new HashMap<>();

    public void signUp(String username, String password) {
        // Avoid storing plain text passwords in production code!
        // In a real application, you would hash the password here.
        users.put(username, password);
    }

    public boolean validateUser(String username, String password) {
        // Retrieve the stored password for the user
        String storedPassword = users.get(username);
        if (storedPassword != null && storedPassword.equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Task122 app = new Task122();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        app.signUp(username, password);

        System.out.print("Enter username to validate: ");
        username = scanner.nextLine();

        System.out.print("Enter password to validate: ");
        password = scanner.nextLine();

        if (app.validateUser(username, password)) {
            System.out.println("User validated successfully.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}