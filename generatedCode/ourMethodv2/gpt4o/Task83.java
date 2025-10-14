import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task83 {

    public static String encryptWithAESCBC(String keyToEncrypt) throws Exception {
        // Generate AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // Use 256-bit AES
        SecretKey secretKey = keyGen.generateKey();

        // Initialize Cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // Generate random IV
        byte[] iv = new byte[cipher.getBlockSize()];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Encrypt
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        byte[] encrypted = cipher.doFinal(keyToEncrypt.getBytes("UTF-8"));

        // Return IV + Encrypted data as Base64 string
        byte[] encryptedIVAndText = new byte[iv.length + encrypted.length];
        System.arraycopy(iv, 0, encryptedIVAndText, 0, iv.length);
        System.arraycopy(encrypted, 0, encryptedIVAndText, iv.length, encrypted.length);

        return Base64.getEncoder().encodeToString(encryptedIVAndText);
    }

    public static void main(String[] args) {
        try {
            System.out.println(encryptWithAESCBC("TestKey1"));
            System.out.println(encryptWithAESCBC("TestKey2"));
            System.out.println(encryptWithAESCBC("TestKey3"));
            System.out.println(encryptWithAESCBC("TestKey4"));
            System.out.println(encryptWithAESCBC("TestKey5"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}