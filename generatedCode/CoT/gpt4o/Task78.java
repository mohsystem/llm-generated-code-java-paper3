package CoT.gpt4o;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;

import java.io.StringWriter;

public class Task78 {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static String generateRSAPrivateKey() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        
        StringWriter stringWriter = new StringWriter();
        try (PemWriter pemWriter = new PemWriter(stringWriter)) {
            pemWriter.writeObject(new PemObject("RSA PRIVATE KEY", privateKey.getEncoded()));
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