package ourMethod.codestral;
import java.security.*;
import javax.crypto.*;

public class Task106 {
    private KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048, new SecureRandom());
        return generator.generateKeyPair();
    }

    private byte[] encrypt(PublicKey key, String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(message.getBytes());
    }

    private String decrypt(PrivateKey key, byte[] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(encrypted));
    }

    public static void main(String[] args) throws Exception {
        Task106 rsa = new Task106();
        KeyPair keyPair = rsa.generateKeyPair();
        byte[] encrypted = rsa.encrypt(keyPair.getPublic(), "Hello, World!");
        String decrypted = rsa.decrypt(keyPair.getPrivate(), encrypted);
        System.out.println(decrypted);
    }
}