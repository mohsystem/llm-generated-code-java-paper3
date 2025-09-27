package CoT.gemini;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class Task72 {

    private static final byte[] IV = new byte[16];
    static {
        new SecureRandom().nextBytes(IV);
    }

    public static String encrypt(String data, SecretKey key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivSpec = new IvParameterSpec(IV);
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // Use 256-bit key for better security
        SecretKey key = keyGen.generateKey();

        String[] testCases = {"Hello", "World", "Test", "Longer Test String", "Special Characters !@#$%^&*()"};
        for (String testCase : testCases) {
            String encrypted = encrypt(testCase, key);
            System.out.println("Original: " + testCase);
            System.out.println("Encrypted: " + encrypted);
        }
    }
}