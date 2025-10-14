package ourMethod.openai;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Task122 {
    private static Map<String, String> userDatabase = new HashMap<>();

    public static boolean signUp(String username, String password) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return false;
        }
        if (userDatabase.containsKey(username)) {
            return false; // Username already exists
        }
        String hashedPassword = hashPassword(password);
        if (hashedPassword == null) {
            return false;
        }
        userDatabase.put(username, hashedPassword);
        return true;
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(signUp("user1", "password123")); // Expected: true
        System.out.println(signUp("user1", "anotherPassword")); // Expected: false (duplicate username)
        System.out.println(signUp("user2", "pass")); // Expected: true
        System.out.println(signUp("", "password")); // Expected: false (invalid username)
        System.out.println(signUp("user3", "")); // Expected: false (invalid password)
    }
}