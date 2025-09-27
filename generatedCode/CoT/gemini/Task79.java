package CoT.gemini;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Task79 {

    public static String encryptMessage(String message, String secretKey) throws Exception {
        // Generate a SecretKey from the provided string
        SecretKey key = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");

        // Create the cipher
        Cipher cipher = Cipher.getInstance("AES");

        // Initialize the cipher for encryption
        cipher.init(Cipher.ENCRYPT_MODE, key);


        // Encrypt the message
        byte[] encryptedMessage = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));

        // Encode the encrypted message using Base64
        return Base64.getEncoder().encodeToString(encryptedMessage);

    }

    public static void main(String[] args) throws Exception {
        String message1 = "This is a secret message.";
        String key1 = "MySecretKey123";
        System.out.println("Encrypted Message 1: " + encryptMessage(message1, key1));


        String message2 = "Another message to encrypt.";
        String key2 = "ASecretKey";
        System.out.println("Encrypted Message 2: " + encryptMessage(message2, key2));


        String message3 = "short message";
        String key3 = "key123";
        System.out.println("Encrypted Message 3: " + encryptMessage(message3, key3));

        String message4 = "A slightly longer message to test encryption.";
        String key4 = "ThisIsALongerKey";
        System.out.println("Encrypted Message 4: " + encryptMessage(message4, key4));

        String message5 = "Special characters: !@#$%^&*()_+=-`~[]\';,./{}|:\"<>?";
        String key5 = "ComplexKey!";
        System.out.println("Encrypted Message 5: " + encryptMessage(message5, key5));
    }
}