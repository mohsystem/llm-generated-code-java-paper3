package CoT.codestral;
// Note: This requires Java 8+ and the Unlimited Strength Jurisdiction Policy Files
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class Task83 {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    public static String encrypt(String key, String value) throws Exception {
        SecretKey secretKey = generateKey(key);
        IvParameterSpec ivParameterSpec = generateIv();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        byte[] encryptedByteValue = cipher.doFinal(value.getBytes("utf-8"));
        return Base64.getEncoder().encodeToString(encryptedByteValue);
    }

    private static SecretKey generateKey(String key) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }

    private static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        return new IvParameterSpec(iv);
    }

    public static void main(String[] args) throws Exception {
        String key = "1234567812345678";
        String value = "This is a secret message";
        String encryptedValue = encrypt(key, value);
        System.out.println("Encrypted: " + encryptedValue);
    }
}