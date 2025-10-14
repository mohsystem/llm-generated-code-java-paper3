package ourMethodv2.gpt4o;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Task133 {
    private Map<String, String> userDatabase = new HashMap<>();

    public boolean resetPassword(String username, String newPassword) {
        if (userDatabase.containsKey(username) && validatePassword(newPassword)) {
            userDatabase.put(username, hashPassword(newPassword));
            return true;
        }
        return false;
    }

    private boolean validatePassword(String password) {
        // Validate password strength
        if (password.length() < 8) return false;
        if (!Pattern.compile("[a-zA-Z]").matcher(password).find()) return false;
        if (!Pattern.compile("[0-9]").matcher(password).find()) return false;
        if (!Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) return false;
        return true;
    }

    private String hashPassword(String password) {
        // Secure password hashing with salt
        String salt = generateSalt();
        return org.apache.commons.codec.digest.DigestUtils.sha256Hex(salt + password);
    }

    private String generateSalt() {
        // Generate a secure random salt
        return java.util.UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        Task133 task = new Task133();
        task.userDatabase.put("user1", "oldPasswordHash");

        System.out.println(task.resetPassword("user1", "NewPass1!")); // true
        System.out.println(task.resetPassword("user1", "weak")); // false
        System.out.println(task.resetPassword("user2", "NewPass1!")); // false
        System.out.println(task.resetPassword("user1", "Another1#")); // true
        System.out.println(task.resetPassword("user1", "12345678")); // false
    }
}