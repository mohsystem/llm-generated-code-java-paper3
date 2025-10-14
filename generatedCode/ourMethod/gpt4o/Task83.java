package ourMethod.openai;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task83 {

    public static String encryptAES(String key) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256, secureRandom); // use 256-bit key for strong encryption
        SecretKey secretKey = keyGen.generateKey();

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] iv = new byte[cipher.getBlockSize()];
        secureRandom.nextBytes(iv);
        IvParameterSpec ivParams = new IvParameterSpec(iv);

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParams);
        byte[] encrypted = cipher.doFinal(key.getBytes());

        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static void main(String[] args) {
        try {
            System.out.println(encryptAES("testKey1"));
            System.out.println(encryptAES("testKey2"));
            System.out.println(encryptAES("testKey3"));
            System.out.println(encryptAES("testKey4"));
            System.out.println(encryptAES("testKey5"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}