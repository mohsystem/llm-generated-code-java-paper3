package ourMethodv2.gpt4o;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

public class Task122 {

    private Map<String, String> userPasswords = new HashMap<>();

    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
    
    public boolean signUp(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password cannot be null.");
        }
        if (userPasswords.containsKey(username)) {
            return false; // Username already exists
        }
        
        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);
        userPasswords.put(username, salt + ":" + hashedPassword);
        return true;
    }
    
    private String generateSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    private String hashPassword(String password, String salt) {
        char[] chars = password.toCharArray();
        byte[] saltBytes = Base64.getDecoder().decode(salt);
        
        PBEKeySpec spec = new PBEKeySpec(chars, saltBytes, ITERATIONS, KEY_LENGTH);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = skf.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Task122 task = new Task122();
        System.out.println(task.signUp("user1", "Password123")); // true
        System.out.println(task.signUp("user1", "Password123")); // false
        System.out.println(task.signUp("user2", "Password123")); // true
        System.out.println(task.signUp("user3", "Password123")); // true
        System.out.println(task.signUp("user4", "Password123")); // true
    }
}