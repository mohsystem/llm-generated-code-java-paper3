package ourMethod.llama31;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task83 {
    public static void main(String[] args) throws Exception {
        String key = "0123456789abcdef"; // 16 bytes (128 bits)
        String iv = "0123456789abcdef"; // 16 bytes (128 bits)
        String plaintext = "This is a test message.";

        byte[] encrypted = aesCbcEncrypt(key.getBytes(), iv.getBytes(), plaintext.getBytes());
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
    }

    public static byte[] aesCbcEncrypt(byte[] key, byte[] iv, byte[] plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        return cipher.doFinal(plaintext);
    }
}