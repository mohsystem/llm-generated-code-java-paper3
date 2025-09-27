package CoT.codestral;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.Base64;

public class Task72 {
    private static final byte[] IV = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    private static final String KEY = "1234567890123456";

    public static String encrypt(String value) throws Exception {
        IvParameterSpec iv = new IvParameterSpec(IV);
        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);
        byte[] encrypted = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(encrypt("Test Data"));
    }
}