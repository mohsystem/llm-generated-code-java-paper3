package ourMethod.openai;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Arrays;

public class Task72 {

    public static byte[] encryptData(byte[] data, byte[] key) throws Exception {
        // Ensure key size is 128/192/256 bits
        if (key.length != 16 && key.length != 24 && key.length != 32) {
            throw new IllegalArgumentException("Invalid key size.");
        }

        // Create a static IV
        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        
        // Initialize cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Encrypt data
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivSpec);
        byte[] encryptedData = cipher.doFinal(data);

        // Combine IV and encrypted data for output
        byte[] combinedData = new byte[iv.length + encryptedData.length];
        System.arraycopy(iv, 0, combinedData, 0, iv.length);
        System.arraycopy(encryptedData, 0, combinedData, iv.length, encryptedData.length);

        return combinedData;
    }

    public static void main(String[] args) throws Exception {
        byte[] key = new byte[16]; // 128-bit key
        new SecureRandom().nextBytes(key);

        byte[] data1 = "Hello World 1".getBytes();
        byte[] data2 = "Hello World 2".getBytes();
        byte[] data3 = "Hello World 3".getBytes();
        byte[] data4 = "Hello World 4".getBytes();
        byte[] data5 = "Hello World 5".getBytes();

        System.out.println(Arrays.toString(encryptData(data1, key)));
        System.out.println(Arrays.toString(encryptData(data2, key)));
        System.out.println(Arrays.toString(encryptData(data3, key)));
        System.out.println(Arrays.toString(encryptData(data4, key)));
        System.out.println(Arrays.toString(encryptData(data5, key)));
    }
}