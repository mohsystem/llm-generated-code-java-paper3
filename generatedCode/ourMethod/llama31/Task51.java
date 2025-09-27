package ourMethod.llama31;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class Task51 {
    public static void main(String[] args) throws Exception {
        String plaintext = "This is a secret message";
        String key = "0123456789abcdef"; // 16 bytes (128 bits) key
        byte[] iv = new byte[16]; // Initialization vector
        new SecureRandom().nextBytes(iv);

        byte[] encrypted = encrypt(plaintext, key, iv);
        byte[] decrypted = decrypt(encrypted, key, iv);

        System.out.println("Plaintext: " + plaintext);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        System.out.println("Decrypted: " + new String(decrypted, StandardCharsets.UTF_8));
    }

    public static byte[] encrypt(String plaintext, String key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        return cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] decrypt(byte[] ciphertext, String key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
        return cipher.doFinal(ciphertext);
    }
}