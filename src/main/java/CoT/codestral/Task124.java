package CoT.codestral;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Task124 {
    private static SecretKey key;

    public static void setKey(String myKey) throws Exception {
        byte[] keyBytes = myKey.getBytes("UTF-8");
        key = new SecretKeySpec(keyBytes, "AES");
    }

    public static String encrypt(String value, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedByteValue = cipher.doFinal(value.getBytes("utf-8"));
        return Base64.getEncoder().encodeToString(encryptedByteValue);
    }

    public static String decrypt(String encryptedValue, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedValue64 = Base64.getDecoder().decode(encryptedValue);
        byte[] decryptedByteValue = cipher.doFinal(decryptedValue64);
        return new String(decryptedByteValue,"utf-8");
    }

    public static void main(String[] args) throws Exception {
        setKey("MySecretKey12345");
        String data = "Sensitive information";
        String encryptedData = encrypt(data, key);
        System.out.println("Encrypted data: " + encryptedData);
        String decryptedData = decrypt(encryptedData, key);
        System.out.println("Decrypted data: " + decryptedData);
    }
}