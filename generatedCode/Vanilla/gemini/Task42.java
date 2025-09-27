package Vanilla.gemini;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

class Task42 {

    private static final Map<String, String> users = new HashMap<>();

    public static boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        }
        String hashedPassword = hashPassword(password);
        users.put(username, hashedPassword);
        return true;
    }

    public static boolean authenticateUser(String username, String password) {
        if (!users.containsKey(username)) {
            return false;
        }
        String storedHashedPassword = users.get(username);
        String hashedPassword = hashPassword(password);
        return storedHashedPassword.equals(hashedPassword);
    }


    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        registerUser("user1", "password123");
        registerUser("user2", "securepass");

        System.out.println(authenticateUser("user1", "password123")); //true
        System.out.println(authenticateUser("user1", "wrongpass")); //false
        System.out.println(authenticateUser("user2", "securepass")); //true
        System.out.println(authenticateUser("user3", "pass")); //false
        System.out.println(registerUser("user1", "newpass")); //false


    }
}