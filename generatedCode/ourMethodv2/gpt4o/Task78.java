package ourMethodv2.gpt4o;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.util.Base64;

public class Task78 {

    public static String generateRSAPrivateKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) pair.getPrivate();
        byte[] encoded = privateKey.getEncoded();
        String privateKeyPEM = "-----BEGIN RSA PRIVATE KEY-----\n";
        privateKeyPEM += Base64.getMimeEncoder().encodeToString(encoded);
        privateKeyPEM += "\n-----END RSA PRIVATE KEY-----";
        return privateKeyPEM;
    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Test Case " + (i + 1) + ":");
                System.out.println(generateRSAPrivateKey());
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}