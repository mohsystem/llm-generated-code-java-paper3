package ZeroShot.claude;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Task51 {
    private static final String ALGORITHM = "AES";
    private static final String KEY = "MySecretKey12345"; // 16 bytes key
    
    public static String encrypt(String input) {
        try {
            SecretKeySpec key = new SecretKeySpec(KEY.getBytes("UTF-8"), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(input.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            return "Encryption failed";
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
            "Hello World",
            "SecretMessage123",
            "Test@123",
            "Special$Characters#",
            "LongTextToEncrypt12345"
        };
        
        for (String test : testCases) {
            System.out.println("Original: " + test);
            System.out.println("Encrypted: " + encrypt(test));
            System.out.println();
        }
    }
}
