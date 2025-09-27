package ourMethod.codestral;
import java.util.Scanner;

public class Task73 {
    private static final String ADMIN_PASSWORD = "AdminPassword123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the admin password: ");
        String inputPassword = scanner.nextLine();
        scanner.close();

        if (isValidPassword(inputPassword)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }

    private static boolean isValidPassword(String password) {
        return ADMIN_PASSWORD.equals(password);
    }
}