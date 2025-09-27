package ZeroShot.gemini;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

class Task79 {
    public static String encryptMessage(String message, String secretKey) throws Exception {
        byte[] keyBytes = secretKey.getBytes("UTF-8");
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encryptedBytes = cipher.doFinal(message.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);

    }

    public static void main(String[] args) throws Exception {
        String[] messages = {"Hello", "World", "Test1", "Test2", "Test3"};
        String secretKey = "MySecretKey123"; // Replace with a strong, randomly generated key

        for (String message : messages) {
            String encryptedMessage = encryptMessage(message, secretKey);
            System.out.println("Encrypted: " + encryptedMessage);
           // System.out.println("Decrypted: " + decryptMessage(encryptedMessage, secretKey));
        }
    }
}