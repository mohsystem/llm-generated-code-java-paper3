package CoT.llama31;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task72 {
    public static void main(String[] args) throws Exception {
        String iv = "0123456789abcdef"; // Static IV
        String key = "0123456789abcdef0123456789abcdef"; // Static key

        String[] testCases = {"Hello", "World", "This is a test", "Encryption in Java", "AES CBC Mode"};

        for (String testCase : testCases) {
            byte[] encrypted = encrypt(testCase, key, iv);
            System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        }
    }

    public static byte[] encrypt(String data, String key, String iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());

        // Pad the data to match the block size
        int blockSize = 16; // AES block size in bytes
        int paddingSize = blockSize - (data.length() % blockSize);
        byte[] paddedData = new byte[data.length() + paddingSize];
        System.arraycopy(data.getBytes(), 0, paddedData, 0, data.length());
        for (int i = data.length(); i < paddedData.length; i++) {
            paddedData[i] = (byte) paddingSize;
        }

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        return cipher.doFinal(paddedData);
    }
}