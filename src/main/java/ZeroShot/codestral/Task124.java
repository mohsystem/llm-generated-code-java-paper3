package ZeroShot.codestral;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Task124 {
    private static SecretKey key;

    public static void main(String[] args) throws Exception {
        key = KeyGenerator.getInstance("AES").generateKey();
        String encrypted = encrypt("Sensitive data");
        String decrypted = decrypt(encrypted);
        System.out.println(decrypted);
    }

    public static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedByteValue = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedByteValue);
    }

    public static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedByteValue = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedByteValue, StandardCharsets.UTF_8);
    }
}