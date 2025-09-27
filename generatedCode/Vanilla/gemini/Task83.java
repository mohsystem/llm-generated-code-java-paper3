package Vanilla.gemini;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task83 {

    public static String encrypt(String key) throws Exception {
        // Generate a random 128-bit AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey aesKey = keyGen.generateKey();


        // Generate a random 16-byte initialization vector
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Create the AES cipher in CBC mode
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey, ivSpec);

        // Encrypt the key
        byte[] encryptedKey = cipher.doFinal(key.getBytes());


        // Combine IV and encrypted key for storage/transmission
        byte[] combined = new byte[iv.length + encryptedKey.length];
        System.arraycopy(iv, 0, combined, 0, iv.length);
        System.arraycopy(encryptedKey, 0, combined, iv.length, encryptedKey.length);



        return Base64.getEncoder().encodeToString(combined);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(encrypt("testkey1"));
        System.out.println(encrypt("testkey22"));
        System.out.println(encrypt("testkey333"));
        System.out.println(encrypt("testkey4444"));
        System.out.println(encrypt("testkey55555"));

    }
}