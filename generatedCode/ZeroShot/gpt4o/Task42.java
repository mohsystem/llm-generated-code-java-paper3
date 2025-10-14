package ZeroShot.openai;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task42 {
    private Map<String, String> userDatabase = new HashMap<>();

    public void registerUser(String username, String password) {
        userDatabase.put(username, hashPassword(password));
    }

    public boolean authenticateUser(String username, String password) {
        if (!userDatabase.containsKey(username)) {
            return false;
        }
        return userDatabase.get(username).equals(hashPassword(password));
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Task42 authSystem = new Task42();
        authSystem.registerUser("user1", "password1");
        authSystem.registerUser("user2", "password2");
        authSystem.registerUser("user3", "password3");
        authSystem.registerUser("user4", "password4");
        authSystem.registerUser("user5", "password5");

        System.out.println(authSystem.authenticateUser("user1", "password1")); // true
        System.out.println(authSystem.authenticateUser("user2", "wrongpass")); // false
        System.out.println(authSystem.authenticateUser("user3", "password3")); // true
        System.out.println(authSystem.authenticateUser("user4", "password4")); // true
        System.out.println(authSystem.authenticateUser("user5", "wrongpass")); // false
    }
}