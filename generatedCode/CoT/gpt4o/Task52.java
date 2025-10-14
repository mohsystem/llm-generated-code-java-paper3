package CoT.openai;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;

public class Task52 {

    public static byte[] encrypt(byte[] data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(encryptedData);
    }

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128, SecureRandom.getInstanceStrong());
        return keyGen.generateKey();
    }

    public static void main(String[] args) throws Exception {
        SecretKey key = generateKey();

        byte[] data1 = "Test data 1".getBytes();
        byte[] encryptedData1 = encrypt(data1, key);
        byte[] decryptedData1 = decrypt(encryptedData1, key);
        System.out.println(new String(decryptedData1));

        byte[] data2 = "Test data 2".getBytes();
        byte[] encryptedData2 = encrypt(data2, key);
        byte[] decryptedData2 = decrypt(encryptedData2, key);
        System.out.println(new String(decryptedData2));

        byte[] data3 = "Test data 3".getBytes();
        byte[] encryptedData3 = encrypt(data3, key);
        byte[] decryptedData3 = decrypt(encryptedData3, key);
        System.out.println(new String(decryptedData3));

        byte[] data4 = "Test data 4".getBytes();
        byte[] encryptedData4 = encrypt(data4, key);
        byte[] decryptedData4 = decrypt(encryptedData4, key);
        System.out.println(new String(decryptedData4));

        byte[] data5 = "Test data 5".getBytes();
        byte[] encryptedData5 = encrypt(data5, key);
        byte[] decryptedData5 = decrypt(encryptedData5, key);
        System.out.println(new String(decryptedData5));
    }
}