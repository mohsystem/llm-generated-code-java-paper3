package ZeroShot.openai;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

public class Task78 {
    public static String generateRSAPrivateKey() {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(2048);
            KeyPair pair = keyPairGen.generateKeyPair();

            RSAPrivateKey privateKey = (RSAPrivateKey) pair.getPrivate();
            RSAPublicKey publicKey = (RSAPublicKey) pair.getPublic();

            String privateKeyPem = "-----BEGIN RSA PRIVATE KEY-----\n" +
                    Base64.getMimeEncoder(64, new byte[]{'\n'}).encodeToString(privateKey.getEncoded()) +
                    "\n-----END RSA PRIVATE KEY-----";

            return privateKeyPem;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Test case " + (i + 1) + ":");
            System.out.println(generateRSAPrivateKey());
            System.out.println();
        }
    }
}