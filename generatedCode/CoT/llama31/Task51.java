package CoT.llama31;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task51 {
    public static void main(String[] args) throws Exception {
        String[] testCases = {"Hello, World!", "This is a test string", "Cipher Block Chaining", "Encryption and Decryption", "Secure Communication"};
        for (String testCase : testCases) {
            byte[] encrypted = encrypt(testCase, "mysecretkey123", "myiv123456");
            byte[] decrypted = decrypt(encrypted, "mysecretkey123", "myiv123456");
            System.out.println("Original: " + testCase);
            System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
            System.out.println("Decrypted: " + new String(decrypted));
            System.out.println();
        }
    }

    public static byte[] encrypt(String plaintext, String key, String iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        return cipher.doFinal(plaintext.getBytes());
    }

    public static byte[] decrypt(byte[] ciphertext, String key, String iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
        return cipher.doFinal(ciphertext);
    }
}