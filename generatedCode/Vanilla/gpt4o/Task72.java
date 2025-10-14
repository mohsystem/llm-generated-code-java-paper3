package Vanilla.openai;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Task72 {

    public static String encrypt(String plainText) throws Exception {
        // Generate AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();

        // Static Initialization Vector
        byte[] ivBytes = new byte[16]; // AES block size is 16 bytes
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        // Initialize Cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        // Encrypt Data
        byte[] encryptedData = cipher.doFinal(plainText.getBytes());

        // Return Base64 encoded encrypted data
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static void main(String[] args) {
        try {
            System.out.println(encrypt("Test1"));
            System.out.println(encrypt("Test2"));
            System.out.println(encrypt("Test3"));
            System.out.println(encrypt("Test4"));
            System.out.println(encrypt("Test5"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}