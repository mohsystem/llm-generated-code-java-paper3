package ourMethod.gemini;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class Task42 {

    private static final Map<String, String> users = new HashMap<>();
    private static final SecureRandom secureRandom = new SecureRandom();

    public static boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // Username already exists
        }

        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);
        users.put(username, salt + ":" + hashedPassword);
        return true;
    }

    public static boolean authenticateUser(String username, String password) {
        if (!users.containsKey(username)) {
            return false; // Username not found
        }

        String storedCredentials = users.get(username);
        String[] parts = storedCredentials.split(":");
        String salt = parts[0];
        String hashedPassword = parts[1];

        String submittedHashedPassword = hashPassword(password, salt);
        return submittedHashedPassword.equals(hashedPassword);
    }


    private static String generateSalt() {
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return bytesToHex(salt);
    }

    private static String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            md.update(password.getBytes());
            byte[] hashedPassword = md.digest();
            return bytesToHex(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            // Handle exception appropriately in a real application
            e.printStackTrace();
            return null;
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        // Test cases
        registerUser("user1", "password123");
        registerUser("user2", "P@$$wOrd");
        registerUser("bob", "bobspassword");


        System.out.println(authenticateUser("user1", "password123")); // Expected: true
        System.out.println(authenticateUser("user1", "wrongpassword")); // Expected: false
        System.out.println(authenticateUser("user2", "P@$$wOrd")); // Expected: true
        System.out.println(authenticateUser("nonexistentuser", "password")); // Expected: false
        System.out.println(authenticateUser("bob", "bobspassword")); // Expected: true

    }
}