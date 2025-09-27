package ZeroShot.gpt4o;
import java.util.HashMap;
import java.util.Scanner;

public class Task133 {
    private HashMap<String, String> userDatabase = new HashMap<>();

    public boolean resetPassword(String username, String oldPassword, String newPassword) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(oldPassword)) {
            if (isValidPassword(newPassword)) {
                userDatabase.put(username, newPassword);
                return true;
            }
        }
        return false;
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8 && password.chars().anyMatch(Character::isDigit)
                && password.chars().anyMatch(Character::isUpperCase)
                && password.chars().anyMatch(Character::isLowerCase)
                && password.chars().anyMatch(ch -> "!@#$%^&*()_+".indexOf(ch) >= 0);
    }

    public static void main(String[] args) {
        Task133 task = new Task133();
        task.userDatabase.put("user1", "Password123!");
        task.userDatabase.put("user2", "Secret123!");

        System.out.println(task.resetPassword("user1", "Password123!", "NewPass123!")); // true
        System.out.println(task.resetPassword("user1", "WrongPass", "NewPass123!")); // false
        System.out.println(task.resetPassword("user2", "Secret123!", "short1!")); // false
        System.out.println(task.resetPassword("user2", "Secret123!", "ValidPass123!")); // true
        System.out.println(task.resetPassword("user3", "SomePass", "NewPass123!")); // false
    }
}