package CoT.openai;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task82 {
    public static String hashPasswordWithSalt(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String input = password + salt;
            byte[] hashBytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found.");
        }
    }

    public static void main(String[] args) {
        System.out.println(hashPasswordWithSalt("password1", "salt1"));
        System.out.println(hashPasswordWithSalt("password2", "salt2"));
        System.out.println(hashPasswordWithSalt("password3", "salt3"));
        System.out.println(hashPasswordWithSalt("password4", "salt4"));
        System.out.println(hashPasswordWithSalt("password5", "salt5"));
    }
}