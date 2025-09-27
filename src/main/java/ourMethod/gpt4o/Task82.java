package ourMethod.gpt4o;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Task82 {
    public static String hashPasswordWithSalt(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] hashedPassword = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        String salt = Base64.getEncoder().encodeToString(saltBytes);
        
        System.out.println(hashPasswordWithSalt("password1", salt));
        System.out.println(hashPasswordWithSalt("password2", salt));
        System.out.println(hashPasswordWithSalt("password3", salt));
        System.out.println(hashPasswordWithSalt("password4", salt));
        System.out.println(hashPasswordWithSalt("password5", salt));
    }
}