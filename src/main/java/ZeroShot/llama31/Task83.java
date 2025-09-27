package ZeroShot.llama31;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task83 {
    public static byte[] aesCbcEncrypt(byte[] key, byte[] iv, byte[] message) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        return cipher.doFinal(message);
    }

    public static void main(String[] args) throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[32]; // 256 bits
        byte[] iv = new byte[16]; // 128 bits
        random.nextBytes(key);
        random.nextBytes(iv);

        String[] messages = {"This is a test message.", "Hello, AES!", "Encryption is secure.", "CBC mode is used.", "AES is widely adopted."};
        for (String message : messages) {
            byte[] encrypted = aesCbcEncrypt(key, iv, message.getBytes());
            System.out.println("Encrypted Message: " + Base64.getEncoder().encodeToString(encrypted));
        }
    }
}