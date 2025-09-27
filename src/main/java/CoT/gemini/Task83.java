package CoT.gemini;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Task83 {

    public static String encrypt(String key) throws Exception {
        // Generate a secure random 128-bit key for AES
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // Use 128-bit key size for AES-128
        SecretKey aesKey = keyGenerator.generateKey();

        // Generate a random IV (Initialization Vector) - should be 16 bytes for AES
        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);


        // Create the cipher in CBC mode
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey, ivSpec);

        // Encrypt the key
        byte[] encryptedKey = cipher.doFinal(key.getBytes());


        // Combine IV and encrypted key for decryption later. IV is prepended to the ciphertext.
        byte[] combined = new byte[iv.length + encryptedKey.length];
        System.arraycopy(iv, 0, combined, 0, iv.length);
        System.arraycopy(encryptedKey, 0, combined, iv.length, encryptedKey.length);

        // Encode the combined byte array using Base64 for safe transport/storage
        return Base64.getEncoder().encodeToString(combined);
    }


    public static void main(String[] args) throws Exception {
        String[] testCases = {"test1", "test2_longer", "test3_with_special_!@#", "test4_1234567890", ""};
        for (String testCase : testCases) {
            String encrypted = encrypt(testCase);
            System.out.println("Encrypted: " + encrypted);
        }

    }
}