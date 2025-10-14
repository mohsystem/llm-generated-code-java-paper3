import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class Task72 {

    private static final byte[] STATIC_IV = new byte[16]; // 16 bytes for AES block size

    static {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(STATIC_IV);
    }

    public static String encryptData(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivSpec = new IvParameterSpec(STATIC_IV);
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
        byte[] encrypted = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static void main(String[] args) {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); // Using 256 bits for strong encryption
            SecretKey secretKey = keyGen.generateKey();

            String[] testCases = {
                "Hello World!",
                "Java Programming",
                "Secure Encryption",
                "OpenAI GPT-3",
                "Static IV Example"
            };

            for (String testCase : testCases) {
                String encrypted = encryptData(testCase, secretKey);
                System.out.println("Original: " + testCase + " | Encrypted: " + encrypted);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}