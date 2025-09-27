package ZeroShot.gemini;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Task51 {

    public static String encrypt(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes());
        byte[] digested = md.digest();
        return Base64.getEncoder().encodeToString(digested);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(encrypt("Hello"));
        System.out.println(encrypt("World"));
        System.out.println(encrypt("Test1"));
        System.out.println(encrypt("Test2"));
        System.out.println(encrypt("Test3"));

    }
}