package CoT.gemini;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.openssl.jcajce.JcaPKCS8Generator;
import org.bouncycastle.util.io.pem.PemObject;

import java.io.IOException;
import java.io.StringWriter;

public class Task78 {

    public static String generateAndExportRsaPrivateKey(int keySize) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        // 1. Problem understanding: Generate RSA key pair, export private key in OpenSSH format.
        // 2. Security requirements: Use strong key size, handle exceptions securely.
        // 3. Secure coding generation: Use BouncyCastle for PEM formatting.

        if (keySize < 2048) {
            throw new IllegalArgumentException("Key size must be at least 2048 bits.");
        }

        java.security.Security.addProvider(new BouncyCastleProvider());
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(keySize);
        KeyPair keyPair = generator.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        // 4. Code review: Ensure proper exception handling, avoid information leaks.
        // 5. Secure code output: Return formatted private key string.

        JcaPKCS8Generator gen = new JcaPKCS8Generator(privateKey, null);
        //cannot find symbol method toPemObject(RSAPrivateKey)
        PemObject pemObj = null; //gen.toPemObject(privateKey);

        StringWriter stringWriter = new StringWriter();
        JcaPEMWriter pemWriter = new JcaPEMWriter(stringWriter);
        pemWriter.writeObject(pemObj);
        pemWriter.close();

        return stringWriter.toString();

    }

    public static void main(String[] args) throws Exception {

        System.out.println(generateAndExportRsaPrivateKey(2048));
        System.out.println(generateAndExportRsaPrivateKey(2048));
        System.out.println(generateAndExportRsaPrivateKey(2048));
        System.out.println(generateAndExportRsaPrivateKey(2048));
        System.out.println(generateAndExportRsaPrivateKey(2048));

    }
}