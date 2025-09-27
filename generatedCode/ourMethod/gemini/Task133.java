package ourMethod.gemini;
import java.util.Random;
import java.util.Scanner;

public class Task133 {

    public static String resetPassword(String username, String email) {
        // Input validation
        if (username == null || username.isEmpty() || email == null || email.isEmpty()) {
            return "Username and email cannot be empty.";
        }

        // Simulate user authentication (replace with actual authentication logic)
        if (!isValidUser(username, email)) {
            return "Invalid username or email.";
        }


        // Generate a new random password
        String newPassword = generateRandomPassword();

        // Simulate updating the password in the database (replace with actual database update logic)
        if (!updatePassword(username, newPassword)) {
            return "Password reset failed.";
        }
        return newPassword;

    }

    private static boolean isValidUser(String username, String email) {
        // Placeholder for user authentication logic
        // Replace with your actual authentication mechanism
        if (username.equals("testuser") && email.equals("test@example.com")) {
            return true;
        } else if (username.equals("user123") && email.equals("user123@mail.com")) {
            return true;
        } else if (username.equals("JaneDoe") && email.equals("jane.doe@domain.net")) {
            return true;
        } else if (username.equals("support") && email.equals("support@company.org")) {
            return true;
        } else if (username.equals("admin") && email.equals("admin@system.gov")) {
            return true;
        }
        return false;
    }

    private static boolean updatePassword(String username, String newPassword) {
        // Placeholder for database update logic
        // Replace with your actual database interaction
        return true;
    }

    private static String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        int passwordLength = 12; // Or any desired length

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < passwordLength; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Test case 1:");
        String username1 = scanner.nextLine();
        String email1 = scanner.nextLine();
        String newPassword1 = resetPassword(username1, email1);
        System.out.println(newPassword1);

        System.out.println("Test case 2:");
        String username2 = scanner.nextLine();
        String email2 = scanner.nextLine();
        String newPassword2 = resetPassword(username2, email2);
        System.out.println(newPassword2);

        System.out.println("Test case 3:");
        String username3 = scanner.nextLine();
        String email3 = scanner.nextLine();
        String newPassword3 = resetPassword(username3, email3);
        System.out.println(newPassword3);

        System.out.println("Test case 4:");
        String username4 = scanner.nextLine();
        String email4 = scanner.nextLine();
        String newPassword4 = resetPassword(username4, email4);
        System.out.println(newPassword4);

        System.out.println("Test case 5:");
        String username5 = scanner.nextLine();
        String email5 = scanner.nextLine();
        String newPassword5 = resetPassword(username5, email5);
        System.out.println(newPassword5);

        scanner.close();
    }
}