package ourMethod.openai;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.io.IOException;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import java.io.StringWriter;

public class Task78 {
    public static String generateRSAPrivateKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();
        PrivateKey privKey = pair.getPrivate();

        // Use BouncyCastle for PEM format
        StringWriter stringWriter = new StringWriter();
        try (JcaPEMWriter pemWriter = new JcaPEMWriter(stringWriter)) {
            pemWriter.writeObject(privKey);
        }

        return stringWriter.toString();
    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(generateRSAPrivateKey());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}