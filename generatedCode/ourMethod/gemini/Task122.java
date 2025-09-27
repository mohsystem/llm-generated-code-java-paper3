package ourMethod.gemini;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

public class Task122 {

    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 256;
    private final Map<String, String> userPasswords = new HashMap<>();


    public void signUp(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Username and password cannot be empty.");
        }

        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);

        userPasswords.put(username, salt + ":" + hashedPassword);
    }

    private String generateSalt() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    private String hashPassword(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), Base64.getDecoder().decode(salt), ITERATIONS, KEY_LENGTH);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        byte[] hash = factory.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(hash);
    }


    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        Task122 passwordManager = new Task122();

        passwordManager.signUp("user1", "password123");
        passwordManager.signUp("user2", "P@$$wOrd");
        passwordManager.signUp("user3", "MyS3cr3t!");
        passwordManager.signUp("user4", "1234567890");
        passwordManager.signUp("user5", "qwerty");

        System.out.println("Passwords stored successfully for 5 users.");


    }
}