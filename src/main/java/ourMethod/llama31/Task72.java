package ourMethod.llama31;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task72 {
    public static void main(String[] args) throws Exception {
        String iv = "0123456789abcdef"; // Static IV
        String key = "0123456789abcdef0123456789abcdef"; // 256-bit key
        String[] data = {"Hello, World!", "This is a test.", "Encryption example."};

        for (String datum : data) {
            byte[] encrypted = encrypt(iv, key, datum.getBytes());
            System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        }
    }

    public static byte[] encrypt(String iv, String key, byte[] data) throws Exception {
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivSpec);

        // Pad the data to match the block size
        int blockSize = cipher.getBlockSize();
        int paddingSize = blockSize - (data.length % blockSize);
        byte[] paddedData = new byte[data.length + paddingSize];
        System.arraycopy(data, 0, paddedData, 0, data.length);
        for (int i = data.length; i < paddedData.length; i++) {
            paddedData[i] = (byte) paddingSize;
        }

        return cipher.doFinal(paddedData);
    }
}