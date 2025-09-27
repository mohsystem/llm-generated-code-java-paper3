package ourMethod.gemini;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfoBuilder;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.pkcs.jcajce.JcePKCS8EncryptedPrivateKeyInfoBuilder;
import org.bouncycastle.operator.bc.BcPBEStringEncryptorBuilder;

import java.io.IOException;
import java.io.StringWriter;
import java.io.StringReader;


public class Task78 {

    public static String generateAndExportRsaPrivateKey() throws NoSuchAlgorithmException, IOException, OperatorCreationException, InvalidKeySpecException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Use a strong key size
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();


        PrivateKeyInfo pkInfo = PrivateKeyInfo.getInstance(privateKey.getEncoded());
        JcaPEMWriter pemWriter = new JcaPEMWriter(new StringWriter());
        pemWriter.writeObject(pkInfo);
        pemWriter.flush();
        String pemKey = pemWriter.toString();
        pemWriter.close();

        return pemKey;
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Test case 1:");
        System.out.println(generateAndExportRsaPrivateKey());

        System.out.println("\nTest case 2:");
        System.out.println(generateAndExportRsaPrivateKey());

        System.out.println("\nTest case 3:");
        System.out.println(generateAndExportRsaPrivateKey());

        System.out.println("\nTest case 4:");
        System.out.println(generateAndExportRsaPrivateKey());

        System.out.println("\nTest case 5:");
        System.out.println(generateAndExportRsaPrivateKey());
    }
}