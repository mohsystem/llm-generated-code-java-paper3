package ourMethod.llama31;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMWriter;

public class Task78 {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        PrivateKey privateKey = kp.getPrivate();

        String privateKeyPEM = "-----BEGIN PRIVATE KEY-----\n" +
                Base64.getMimeEncoder().encodeToString(privateKey.getEncoded()) +
                "\n-----END PRIVATE KEY-----";

        try (PEMWriter pemWriter = new PEMWriter(new FileWriter("private_key.pem"))) {
            pemWriter.writeObject(privateKeyPEM);
        }
    }
}