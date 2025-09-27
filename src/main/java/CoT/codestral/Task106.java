package CoT.codestral;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;

public class Task106 {
    private static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    private static byte[] encrypt(PublicKey publicKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(message.getBytes());
    }

    private static String decrypt(PrivateKey privateKey, byte[] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(encrypted));
    }

    public static void main(String[] args) {
        try {
            KeyPair keyPair = generateKeyPair();
            String[] messages = {"Hello, World!", "Test message 2", "This is a test", "Secure RSA encryption", "Goodbye!"};
            for (String message : messages) {
                byte[] encrypted = encrypt(keyPair.getPublic(), message);
                String decrypted = decrypt(keyPair.getPrivate(), encrypted);
                System.out.println("Original: " + message);
                System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
                System.out.println("Decrypted: " + decrypted);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}