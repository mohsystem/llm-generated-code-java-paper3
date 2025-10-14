package ourMethodv2.gpt4o;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Task102 {

    private static Map<String, String> database = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(updatePassword("user1", "newPassword1"));
        System.out.println(updatePassword("user2", "newPassword2"));
        System.out.println(updatePassword("user3", "newPassword3"));
        System.out.println(updatePassword("user4", "newPassword4"));
        System.out.println(updatePassword("user5", "newPassword5"));
    }

    public static boolean updatePassword(String username, String newPassword) {
        if (username == null || newPassword == null) {
            return false;
        }
        try {
            String hashedPassword = hashPassword(newPassword);
            database.put(username, hashedPassword);
            return true;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            return false;
        }
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = factory.generateSecret(spec).getEncoded();
        
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}