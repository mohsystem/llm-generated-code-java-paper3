package Vanilla.codestral;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Task72 {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final byte[] IV = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static String encrypt(String input, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static void main(String[] args) throws Exception {
        String key = "1234567890123456";
        System.out.println(encrypt("Hello World!", key));
        System.out.println(encrypt("This is a test.", key));
        System.out.println(encrypt("Encryption is fun.", key));
        System.out.println(encrypt("Java is awesome.", key));
        System.out.println(encrypt("Cryptography is hard.", key));
    }
}