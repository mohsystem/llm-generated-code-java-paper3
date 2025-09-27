package ZeroShot.codestral;
import java.io.StringWriter;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.bouncycastle.openssl.PEMWriter;

public class Task78 {

    public static String generateRSAKey() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();

        PEMWriter pemWriter = new PEMWriter(new StringWriter());
        pemWriter.writeObject(privateKey);
        pemWriter.flush();
        pemWriter.close();

        return pemWriter.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(generateRSAKey());
    }
}