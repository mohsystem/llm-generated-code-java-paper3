package ourMethod.llama31;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task79 {
    public static void main(String[] args) throws Exception {
        String secretKey = "your_secret_key_here"; // Ensure this is a secure key
        String message = "This is a secret message";

        // Generate a random IV
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[16];
        random.nextBytes(iv);

        // Encrypt the message
        byte[] encrypted = encrypt(message, secretKey, iv);

        // Print the results
        System.out.println("IV: " + Base64.getEncoder().encodeToString(iv));
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));

        // Decrypt the message
        String decrypted = decrypt(encrypted, secretKey, iv);
        System.out.println("Decrypted: " + decrypted);
    }

    public static byte[] encrypt(String message, String secretKey, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        return cipher.doFinal(message.getBytes());
    }

    public static String decrypt(byte[] encrypted, String secretKey, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        return new String(cipher.doFinal(encrypted));
    }
}