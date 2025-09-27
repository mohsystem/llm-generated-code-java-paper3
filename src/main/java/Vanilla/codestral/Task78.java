package Vanilla.codestral;
import java.io.IOException;
import java.io.StringWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import org.bouncycastle.openssl.PEMWriter;

public class Task78 {
    public static String generateRSAKey() throws NoSuchAlgorithmException, IOException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048, new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        StringWriter stringWriter = new StringWriter();
        PEMWriter pemWriter = new PEMWriter(stringWriter);
        pemWriter.writeObject(privateKey);
        pemWriter.flush();
        pemWriter.close();

        return stringWriter.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        System.out.println(generateRSAKey());
    }
}