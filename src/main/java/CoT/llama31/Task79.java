package CoT.llama31;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class Task79 {
    public static void main(String[] args) throws Exception {
        String[] testCases = {
            "Hello, World!",
            "This is a secret message",
            "Encryption is fun",
            "Cipher Block Chaining",
            "Secure your data"
        };
        String secretKey = "0123456789abcdef"; // 16 bytes for AES-128
        byte[] iv = new byte[16]; // Initialization vector

        for (String testCase : testCases) {
            String encrypted = encrypt(testCase, secretKey, iv);
            System.out.println("Plaintext: " + testCase);
            System.out.println("Encrypted: " + encrypted);
        }
    }

    public static String encrypt(String plaintext, String secretKey, byte[] iv) throws Exception {
        Key key = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(ciphertext);
    }
}