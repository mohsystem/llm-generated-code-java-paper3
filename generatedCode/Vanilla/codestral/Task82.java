package Vanilla.codestral;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Task82 {
    public static String hashPassword(String password, String salt) {
        String combined = password + salt;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(
                combined.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(hashPassword("password1", "salt1"));
        System.out.println(hashPassword("password2", "salt2"));
        System.out.println(hashPassword("password3", "salt3"));
        System.out.println(hashPassword("password4", "salt4"));
        System.out.println(hashPassword("password5", "salt5"));
    }
}