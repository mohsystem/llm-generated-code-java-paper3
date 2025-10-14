package CoT.openai;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Task72 {

    private static final byte[] IV = new byte[16]; // Static Initialization Vector

    public static byte[] encryptData(byte[] inputData) throws Exception {
        SecretKey secretKey = generateSecretKey();
        IvParameterSpec ivSpec = new IvParameterSpec(IV);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        return cipher.doFinal(inputData);
    }

    private static SecretKey generateSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // AES key size
        return keyGen.generateKey();
    }

    public static void main(String[] args) throws Exception {
        byte[] testData1 = "Test Data 1".getBytes();
        byte[] testData2 = "Test Data 2".getBytes();
        byte[] testData3 = "Test Data 3".getBytes();
        byte[] testData4 = "Test Data 4".getBytes();
        byte[] testData5 = "Test Data 5".getBytes();

        System.out.println(Arrays.toString(encryptData(testData1)));
        System.out.println(Arrays.toString(encryptData(testData2)));
        System.out.println(Arrays.toString(encryptData(testData3)));
        System.out.println(Arrays.toString(encryptData(testData4)));
        System.out.println(Arrays.toString(encryptData(testData5)));
    }
}