package Vanilla.gemini;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

class Task134 {

    public static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048); // Adjust key size as needed
        return generator.generateKeyPair();
    }

    public static String encodePublicKey(PublicKey publicKey) {
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());
    }

    public static String encodePrivateKey(PrivateKey privateKey) {
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPair keyPair1 = generateRSAKeyPair();
        System.out.println("Public Key 1: " + encodePublicKey(keyPair1.getPublic()));
        System.out.println("Private Key 1: " + encodePrivateKey(keyPair1.getPrivate()));

        KeyPair keyPair2 = generateRSAKeyPair();
        System.out.println("Public Key 2: " + encodePublicKey(keyPair2.getPublic()));
        System.out.println("Private Key 2: " + encodePrivateKey(keyPair2.getPrivate()));

        KeyPair keyPair3 = generateRSAKeyPair();
        System.out.println("Public Key 3: " + encodePublicKey(keyPair3.getPublic()));
        System.out.println("Private Key 3: " + encodePrivateKey(keyPair3.getPrivate()));

        KeyPair keyPair4 = generateRSAKeyPair();
        System.out.println("Public Key 4: " + encodePublicKey(keyPair4.getPublic()));
        System.out.println("Private Key 4: " + encodePrivateKey(keyPair4.getPrivate()));

        KeyPair keyPair5 = generateRSAKeyPair();
        System.out.println("Public Key 5: " + encodePublicKey(keyPair5.getPublic()));
        System.out.println("Private Key 5: " + encodePrivateKey(keyPair5.getPrivate()));
    }
}