package Vanilla.llama31;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task72 {
    public static byte[] aesCbcEncrypt(byte[] key, byte[] iv, byte[] plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

        // Pad the plaintext to match the block size
        int blockSize = cipher.getBlockSize();
        int paddingSize = blockSize - (plaintext.length % blockSize);
        byte[] paddedPlaintext = new byte[plaintext.length + paddingSize];
        System.arraycopy(plaintext, 0, paddedPlaintext, 0, plaintext.length);
        for (int i = plaintext.length; i < paddedPlaintext.length; i++) {
            paddedPlaintext[i] = (byte) paddingSize;
        }

        return cipher.doFinal(paddedPlaintext);
    }

    public static void main(String[] args) throws Exception {
        byte[] key = new byte[32]; // 256-bit key
        byte[] iv = new byte[16]; // 128-bit IV
        SecureRandom random = new SecureRandom();
        random.nextBytes(key);
        random.nextBytes(iv);

        byte[][] testCases = {
            "This is a test message.".getBytes(),
            "Another test message.".getBytes(),
            "Short message.".getBytes(),
            "Very long message that needs padding.".getBytes(),
            "Single block message.".getBytes()
        };

        for (byte[] testCase : testCases) {
            byte[] encrypted = aesCbcEncrypt(key, iv, testCase);
            System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        }
    }
}