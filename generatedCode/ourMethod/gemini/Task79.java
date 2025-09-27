package ourMethod.gemini;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Task79 {

    public static String encryptMessage(String message, String secretKey) throws Exception {
        // Create a cipher for encryption
        Cipher cipher = Cipher.getInstance("AES");

        // Convert the secret key string to a SecretKey object
        byte[] decodedKey = Base64.getDecoder().decode(secretKey);
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");


        // Initialize the cipher for encryption
        cipher.init(Cipher.ENCRYPT_MODE, originalKey);

        // Encrypt the message
        byte[] encryptedMessage = cipher.doFinal(message.getBytes());

        // Encode the encrypted message to Base64
        return Base64.getEncoder().encodeToString(encryptedMessage);
    }

    public static void main(String[] args) throws Exception {
        // Test cases
        String[][] testCases = {
                {"Hello", "ThisIsASecretKey"}, //invalid key
                {"Hello", "yHB0eE1iY3dQR2lzCg=="},
                {"World", "yHB0eE1iY3dQR2lzCg=="},
                {"This is a test", "yHB0eE1iY3dQR2lzCg=="},
                {"", "yHB0eE1iY3dQR2lzCg=="}
        };

        for (String[] testCase : testCases) {
             try {
                String encryptedMessage = encryptMessage(testCase[0], testCase[1]);
                System.out.println("Original Message: " + testCase[0]);
                System.out.println("Encrypted Message: " + encryptedMessage);
             } catch (Exception e) {
                 System.out.println("Error: " + e.getMessage());
             }
        }


        //generate valid key for AES
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // for example
        SecretKey secretKey = keyGen.generateKey();
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());

        System.out.println("Generated key:" + encodedKey); //yHB0eE1iY3dQR2lzCg==

    }
}