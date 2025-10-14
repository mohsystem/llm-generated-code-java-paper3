package Vanilla.openai;
import java.security.*;
import java.security.spec.*;
import java.util.Base64;
import javax.crypto.Cipher;

public class Task78 {

    public static String generatePrivateKey() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();

        byte[] privBytes = privateKey.getEncoded();
        String privKeyBase64 = Base64.getEncoder().encodeToString(privBytes);
        
        return "-----BEGIN RSA PRIVATE KEY-----\n" + privKeyBase64 + "\n-----END RSA PRIVATE KEY-----";
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println(generatePrivateKey());
        }
    }
}