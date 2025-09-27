package ZeroShot.gpt4o;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Task52 {

    private static final String ALGORITHM = "AES";

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128);
        return keyGen.generateKey();
    }

    public static byte[] encrypt(byte[] data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(encryptedData);
    }

    public static void main(String[] args) throws Exception {
        SecretKey key = generateKey();
        String data = "This is a test.";

        byte[] encrypted = encrypt(data.getBytes(), key);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));

        byte[] decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted: " + new String(decrypted));
    }
}