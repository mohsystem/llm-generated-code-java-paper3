package CoT.gpt4o;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class Task83 {
    public static String encryptAES(String key, String data) throws Exception {
        byte[] keyBytes = key.getBytes("UTF-8");
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] iv = new byte[cipher.getBlockSize()];
        IvParameterSpec ivParams = new IvParameterSpec(iv);

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParams);
        byte[] encrypted = cipher.doFinal(data.getBytes("UTF-8"));

        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static void main(String[] args) {
        try {
            String key = "examplekey123456";
            System.out.println(encryptAES(key, "TestCase1"));
            System.out.println(encryptAES(key, "TestCase2"));
            System.out.println(encryptAES(key, "TestCase3"));
            System.out.println(encryptAES(key, "TestCase4"));
            System.out.println(encryptAES(key, "TestCase5"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}