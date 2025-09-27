package CoT.gemini;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

class Task51 {

    public static String encrypt(String text) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encodedhash);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(encrypt("Test1"));
        System.out.println(encrypt("Test2"));
        System.out.println(encrypt("Test3"));
        System.out.println(encrypt("Test4"));
        System.out.println(encrypt("Test5"));

    }
}