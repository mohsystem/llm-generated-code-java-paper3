package ZeroShot.codestral;
import java.security.*;
import javax.crypto.*;

public class Task106 {
    private KeyPair keyPair;

    public Task106() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        this.keyPair = keyPairGenerator.generateKeyPair();
    }

    public byte[] encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        return cipher.doFinal(data.getBytes());
    }

    public String decrypt(byte[] encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        return new String(cipher.doFinal(encryptedData));
    }

    public static void main(String[] args) throws Exception {
        Task106 rsa = new Task106();
        String data = "Hello, World!";
        byte[] encryptedData = rsa.encrypt(data);
        String decryptedData = rsa.decrypt(encryptedData);
        System.out.println("Original: " + data);
        System.out.println("Encrypted: " + new String(encryptedData));
        System.out.println("Decrypted: " + decryptedData);
    }
}