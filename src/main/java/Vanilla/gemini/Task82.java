package Vanilla.gemini;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task82 {

    public static String getSaltedPasswordHash(String password, String salt) throws NoSuchAlgorithmException {
        String saltedPassword = salt + password;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(saltedPassword.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(getSaltedPasswordHash("password123", "salt1"));
        System.out.println(getSaltedPasswordHash("test", "salt2"));
        System.out.println(getSaltedPasswordHash("123456", "salt3"));
        System.out.println(getSaltedPasswordHash("qwerty", "salt4"));
        System.out.println(getSaltedPasswordHash("password", "salt5"));
    }
}