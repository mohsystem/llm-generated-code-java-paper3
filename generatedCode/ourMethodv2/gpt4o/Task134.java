package ourMethodv2.gpt4o;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Task134 {

    public KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048); // Secure key size
            return keyGen.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Task134 task = new Task134();
        
        // Test cases
        for (int i = 0; i < 5; i++) {
            KeyPair keyPair = task.generateKeyPair();
            if (keyPair != null) {
                PublicKey pubKey = keyPair.getPublic();
                PrivateKey privKey = keyPair.getPrivate();
                System.out.println("Test case " + (i + 1) + ":");
                System.out.println("Public Key: " + pubKey);
                System.out.println("Private Key: " + privKey);
            }
        }
    }
}