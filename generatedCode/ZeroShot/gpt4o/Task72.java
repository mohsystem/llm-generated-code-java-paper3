package ZeroShot.openai;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task72 {

    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final byte[] STATIC_IV = new byte[16]; // static IV for demonstration purposes

    static {
        SecureRandom random = new SecureRandom();
        random.nextBytes(STATIC_IV);
    }

    public static String encrypt(String data, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(STATIC_IV);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();

        System.out.println(encrypt("Test1", secretKey));
        System.out.println(encrypt("Test2", secretKey));
        System.out.println(encrypt("Test3", secretKey));
        System.out.println(encrypt("Test4", secretKey));
        System.out.println(encrypt("Test5", secretKey));
    }
}