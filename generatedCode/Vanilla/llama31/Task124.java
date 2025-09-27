package Vanilla.llama31;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Task124 {
    public static void main(String[] args) throws Exception {
        String[] testCases = {
            "1234-5678-9012-3456",
            "John Doe",
            "123 Main St",
            "123-456-7890",
            "johndoe@example.com"
        };

        for (String testCase : testCases) {
            String encrypted = encrypt(testCase);
            String decrypted = decrypt(encrypted);
            System.out.println("Original: " + testCase);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
            System.out.println();
        }
    }

    public static String encrypt(String data) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128, new SecureRandom());
        SecretKey secretKey = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes) + ":" + Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    public static String decrypt(String encrypted) throws Exception {
        String[] parts = encrypted.split(":");
        byte[] encryptedBytes = Base64.getDecoder().decode(parts[0]);
        byte[] keyBytes = Base64.getDecoder().decode(parts[1]);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        return new String(cipher.doFinal(encryptedBytes));
    }
}