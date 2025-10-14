package ZeroShot.openai;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class Task83 {
    public static String encrypt(String plainText, SecretKey secretKey, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivParams = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParams);
        byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();
        byte[] iv = new byte[16]; // Normally would use SecureRandom to generate IV

        // Test cases
        System.out.println(encrypt("Test123", secretKey, iv));
        System.out.println(encrypt("HelloWorld", secretKey, iv));
        System.out.println(encrypt("JavaEncryption", secretKey, iv));
        System.out.println(encrypt("SecureCode", secretKey, iv));
        System.out.println(encrypt("CipherTest", secretKey, iv));
    }
}