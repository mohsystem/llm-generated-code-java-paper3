package ZeroShot.llama31;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task72 {
    public static byte[] encryptAES(byte[] data, byte[] key) throws Exception {
        // Create a static IV
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);

        // Initialize the cipher
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        // Pad the data to match the block size
        int blockSize = cipher.getBlockSize();
        int paddingSize = blockSize - (data.length % blockSize);
        byte[] paddedData = new byte[data.length + paddingSize];
        System.arraycopy(data, 0, paddedData, 0, data.length);
        for (int i = data.length; i < paddedData.length; i++) {
            paddedData[i] = (byte) paddingSize;
        }

        // Encrypt the padded data
        byte[] encryptedData = cipher.doFinal(paddedData);

        // Return the IV and the encrypted data
        byte[] result = new byte[iv.length + encryptedData.length];
        System.arraycopy(iv, 0, result, 0, iv.length);
        System.arraycopy(encryptedData, 0, result, iv.length, encryptedData.length);

        return result;
    }

    public static void main(String[] args) throws Exception {
        byte[] key = "0123456789abcdef".getBytes(); // 16 bytes for AES-128
        byte[][] testCases = {
            "Hello, AES!".getBytes(),
            "This is a test string.".getBytes(),
            "Short string.".getBytes(),
            "Very long string to test padding.".getBytes(),
            "Another test string with different length.".getBytes()
        };

        for (byte[] testCase : testCases) {
            byte[] encrypted = encryptAES(testCase, key);
            System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        }
    }
}