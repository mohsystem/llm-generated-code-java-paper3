package ZeroShot.gemini;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Task42 {

    private static final Map<String, String> users = new HashMap<>();

    public static boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // Username already exists
        }

        String hashedPassword = hashPassword(password);
        users.put(username, hashedPassword);
        return true;
    }

    public static boolean authenticateUser(String username, String password) {
        if (!users.containsKey(username)) {
            return false; // Username not found
        }

        String storedHashedPassword = users.get(username);
        String hashedPassword = hashPassword(password);
        return storedHashedPassword.equals(hashedPassword);
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle exception appropriately in a real application
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        registerUser("user1", "password123");
        registerUser("user2", "securepass");

        System.out.println(authenticateUser("user1", "password123")); // True
        System.out.println(authenticateUser("user1", "wrongpass"));   // False
        System.out.println(authenticateUser("user2", "securepass"));  // True
        System.out.println(authenticateUser("user3", "anypass"));    // False (user doesn't exist)
        System.out.println(registerUser("user1", "newpass"));      // False (username already exists)


    }
}