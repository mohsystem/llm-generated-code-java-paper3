package Vanilla.llama31;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class Task83 {
    public static byte[] encryptAES_CBC(byte[] key, byte[] iv, byte[] input) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        return cipher.doFinal(input);
    }

    public static void main(String[] args) throws Exception {
        byte[] key = "0123456789abcdef".getBytes(); // 16 bytes
        byte[] iv = "fedcba9876543210".getBytes(); // 16 bytes
        byte[] input = "Hello, World!".getBytes();

        // Pad the input to a multiple of the block size (16 bytes for AES)
        int blockSize = 16;
        int inputLen = input.length;
        int paddedLen = (inputLen + blockSize - 1) / blockSize * blockSize;
        byte[] paddedInput = new byte[paddedLen];
        System.arraycopy(input, 0, paddedInput, 0, inputLen);

        byte[] encrypted = encryptAES_CBC(key, iv, paddedInput);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
    }
}