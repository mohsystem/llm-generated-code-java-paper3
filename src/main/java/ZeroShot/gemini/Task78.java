package ZeroShot.gemini;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.openssl.jcajce.JcaPKCS8Generator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfoBuilder;
import org.bouncycastle.pkcs.PKCSException;
import org.bouncycastle.pkcs.jcajce.JcePKCSPBEOutputEncryptorBuilder;
import org.bouncycastle.asn1.pkcs.EncryptionScheme;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import java.io.StringWriter;
import java.io.IOException;
import java.security.Security;



public class Task78 {

    public static String generateAndExportRsaPrivateKey(String passphrase) throws NoSuchAlgorithmException, OperatorCreationException, IOException, PKCSException, InvalidKeySpecException {
        Security.addProvider(new BouncyCastleProvider());
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048); // Key size
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();

        if (passphrase != null && !passphrase.isEmpty()) { // Encrypt with passphrase if provided
            //todo cannot find symbol method getDefaultPBEStringEncryptorBuilder(String)

//            JcaPKCS8Generator gen = new JcaPKCS8Generator(privateKey,
//                    JcePKCSPBEOutputEncryptorBuilder.getDefaultPBEStringEncryptorBuilder(passphrase).build());

            StringWriter sw = new StringWriter();
            JcaPEMWriter pemWriter = new JcaPEMWriter(sw);
//            pemWriter.writeObject(gen);
            pemWriter.flush();
            String privateKeyPEM = sw.toString(); // Use toString instead of getWriter
            pemWriter.close();

            return privateKeyPEM;
        } else { // Unencrypted private key
            StringWriter sw = new StringWriter();
            JcaPEMWriter pemWriter = new JcaPEMWriter(sw);
            pemWriter.writeObject(privateKey);
            pemWriter.flush();
            String privateKeyPEM = sw.toString();
            pemWriter.close();
            return privateKeyPEM;
        }
    }



    public static void main(String[] args) throws NoSuchAlgorithmException, OperatorCreationException, IOException, PKCSException, InvalidKeySpecException {
        String key1 = generateAndExportRsaPrivateKey(null);
        System.out.println(key1);
        String key2 = generateAndExportRsaPrivateKey("testpassword");
        System.out.println(key2);
        String key3 = generateAndExportRsaPrivateKey("");
        System.out.println(key3);
        String key4 = generateAndExportRsaPrivateKey("another_password");
        System.out.println(key4);
        String key5 = generateAndExportRsaPrivateKey(null);
        System.out.println(key5);

    }
}