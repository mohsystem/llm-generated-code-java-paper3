package Vanilla.gpt4o;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class Task83 {

    public static String encryptAES(String key) throws Exception {
        // Generate AES key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();

        // Initialize cipher in CBC mode with a random IV
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] iv = new byte[16];
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

        // Encrypt the key
        byte[] encrypted = cipher.doFinal(key.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static void main(String[] args) {
        try {
            System.out.println(encryptAES("This is a test key 1"));
            System.out.println(encryptAES("This is a test key 2"));
            System.out.println(encryptAES("This is a test key 3"));
            System.out.println(encryptAES("This is a test key 4"));
            System.out.println(encryptAES("This is a test key 5"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}