package CoT.codestral;
import java.io.IOException;
import java.io.StringWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.util.io.pem.PemObject;

public class Task78 {
    public static String generateRsaPrivateKey() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();

        PemObject pemObject = new PemObject("OPENSSH PRIVATE KEY", privateKey.getEncoded());
        StringWriter stringWriter = new StringWriter();
        JcaPEMWriter pemWriter = new JcaPEMWriter(stringWriter);
        pemWriter.writeObject(pemObject);
        pemWriter.close();
        return stringWriter.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        System.out.println(generateRsaPrivateKey());
    }
}