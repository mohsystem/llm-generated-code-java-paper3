package ourMethod.codestral;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.util.Base64;

public class Task78 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        String privateKeyString = new String(Base64.getEncoder().encode(privateKey.getEncoded()));
        System.out.println("-----BEGIN RSA PRIVATE KEY-----\n" + privateKeyString + "\n-----END RSA PRIVATE KEY-----");
    }
}