package ZeroShot.gemini;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

class Task72 {
    private static final byte[] IV = new byte[16];
    private static final String KEY = "ThisIsASecretKey"; // Replace with a stronger key generation mechanism

    static {
        new SecureRandom().nextBytes(IV); // Initialize IV with random bytes
    }

    public static String encrypt(String data) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(IV);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static void main(String[] args) throws Exception {
        String[] testCases = {"Hello", "World", "This is a test", "Another test case", "Short"};
        for (String testCase : testCases) {
            String encrypted = encrypt(testCase);
            System.out.println("Encrypted: " + encrypted);
        }
    }
}