package ZeroShot.codestral;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.Base64;

public class Task72 {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final byte[] IV = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static String encrypt(String input, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(IV);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] encrypted = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static void main(String[] args) throws Exception {
        String key = "1234567890123456";
        System.out.println(encrypt("Hello, World!", key));
        System.out.println(encrypt("Secure data encryption", key));
        System.out.println(encrypt("AES CBC Mode", key));
        System.out.println(encrypt("Padding is important", key));
        System.out.println(encrypt("Test case number five", key));
    }
}