package Vanilla.gemini;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class Task72 {

    private static final byte[] IV = new byte[16]; // Static IV

    static {
        new SecureRandom().nextBytes(IV); // Initialize IV with random bytes
    }


    public static String encrypt(String data, String keyString) throws Exception {
        // Generate SecretKey from keyString
        byte[] keyBytes = keyString.getBytes();
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(IV);

        cipher.init(Cipher.ENCRYPT_MODE, key, iv);


        byte[] encrypted = cipher.doFinal(data.getBytes());

        return Base64.getEncoder().encodeToString(encrypted);
    }


    public static void main(String[] args) throws Exception {
        String key = "MySuperSecretKey1"; // Example key (should be 16, 24, or 32 bytes for AES)

        String[] testCases = {"Hello", "World", "This is a test", "Another test case", "A longer string to test padding"};

        for (String testCase : testCases) {
            String encrypted = encrypt(testCase, key);
            System.out.println("Original: " + testCase);
            System.out.println("Encrypted: " + encrypted);
        }
    }
}