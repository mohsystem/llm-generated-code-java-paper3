package CoT.gemini;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

class Task42 {

    private static final Map<String, String> users = new HashMap<>();

    public static boolean authenticate(String username, String password) {
        String storedHashedPassword = users.get(username);
        if (storedHashedPassword == null) {
            return false; // Username not found
        }
        String hashedPassword = hashPassword(password);
        return storedHashedPassword.equals(hashedPassword);
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] hash = md.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error hashing password: " + e.getMessage());
            return null;
        }
    }

    public static void addUser(String username, String password) {
        String hashedPassword = hashPassword(password);
        users.put(username, hashedPassword);
    }



    public static void main(String[] args) {
        addUser("user1", "password123");
        addUser("user2", "securepass");
        addUser("admin", "adminpass");

        System.out.println(authenticate("user1", "password123")); // True
        System.out.println(authenticate("user2", "wrongpass"));   // False
        System.out.println(authenticate("user3", "anypass"));   // False
        System.out.println(authenticate("admin", "adminpass"));  // True
        System.out.println(authenticate("user1", "password12")); //False


    }
}