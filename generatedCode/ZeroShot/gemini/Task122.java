package ZeroShot.gemini;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

class Task122 {

    private static final Map<String, String> userPasswords = new HashMap<>();

    public static String signup(String username, String password) throws NoSuchAlgorithmException {
        if (userPasswords.containsKey(username)) {
            return "Username already exists.";
        }

        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);
        userPasswords.put(username, salt + ":" + hashedPassword);
        return "Signup successful.";
    }


    private static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }

    private static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update((salt + password).getBytes());
        byte[] hashedPasswordBytes = md.digest();
        return Base64.getEncoder().encodeToString(hashedPasswordBytes);
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(signup("user1", "password123"));
        System.out.println(signup("user2", "securepass"));
        System.out.println(signup("user1", "anotherpass")); // Username already exists
        System.out.println(signup("user3", "p@$$wOrd"));
        System.out.println(signup("user4", "12345678"));


    }
}