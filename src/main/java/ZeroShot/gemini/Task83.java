package ZeroShot.gemini;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

class Task83 {
    public static String encrypt(String key) throws Exception {
        // Generate a secure random key if no key is provided
        if (key == null || key.isEmpty()) {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // You can change the key size here (128, 192, or 256 bits)
            SecretKey secretKey = keyGen.generateKey();
            key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        }
        
        byte[] keyBytes = Base64.getDecoder().decode(key);


        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

        // Generate a random IV (Initialization Vector)
        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);


        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);


        byte[] encryptedBytes = cipher.doFinal(keyBytes);

        // Concatenate IV and encrypted data for decryption later
        byte[] combined = new byte[iv.length + encryptedBytes.length];
        System.arraycopy(iv, 0, combined, 0, iv.length);
        System.arraycopy(encryptedBytes, 0, combined, iv.length, encryptedBytes.length);

        return Base64.getEncoder().encodeToString(combined);
    }

    public static void main(String[] args) throws Exception {
        String[] testCases = {"MySecretKey123", "AnotherKey456", "ShortKey", "LongKey7890123456", ""}; // Include an empty string test case
        for (String testCase : testCases) {
            String encryptedKey = encrypt(testCase);
            System.out.println("Original Key: " + testCase + ", Encrypted Key: " + encryptedKey);
        }

    }
}