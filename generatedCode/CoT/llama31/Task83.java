package CoT.llama31;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task83 {
    public static byte[] aesCbcEncrypt(byte[] key, byte[] iv, byte[] plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        return cipher.doFinal(plaintext);
    }

    public static void main(String[] args) throws Exception {
        // Test cases
        byte[] key = new byte[16]; // 128-bit key
        byte[] iv = new byte[16]; // Initialization Vector
        SecureRandom random = new SecureRandom();
        random.nextBytes(key);
        random.nextBytes(iv);

        byte[][] plaintexts = {
            "This is a test message.".getBytes(),
            "Another test message.".getBytes(),
            "Hello, AES!".getBytes(),
            "Encrypt me!".getBytes(),
            "Secure data here.".getBytes()
        };

        for (byte[] plaintext : plaintexts) {
            byte[] ciphertext = aesCbcEncrypt(key, iv, plaintext);
            System.out.println("Plaintext: " + new String(plaintext));
            System.out.println("Ciphertext: " + Base64.getEncoder().encodeToString(ciphertext));
        }
    }
}