package ourMethod.gemini;
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
        // Generate a secure random key if none is provided
        if (key == null || key.isEmpty()) {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // You can change the key size here (128, 192, or 256)
            SecretKey secretKey = keyGen.generateKey();
            key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        }

        // Generate a secure random IV
        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);

        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(key), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        // Encrypt the key itself (or any other data)
        byte[] encryptedKey = cipher.doFinal(key.getBytes());

        // Concatenate IV and encrypted key for decryption later.  IV is public knowledge
        byte[] combined = new byte[iv.length + encryptedKey.length];
        System.arraycopy(iv, 0, combined, 0, iv.length);
        System.arraycopy(encryptedKey, 0, combined, iv.length, encryptedKey.length);

        return Base64.getEncoder().encodeToString(combined);


    }

    public static void main(String[] args) throws Exception {
        String[] testCases = {"test1", "test2test2", "", "longerkeytest", null};
        for (String testCase : testCases) {
            String encrypted = encrypt(testCase);
            System.out.println("Encrypted: " + encrypted);

        }
    }
}