package ZeroShot.claude;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.*;
import java.util.Base64;

public class Task134 {
    private SecretKey secretKey;
    private KeyPair keyPair;

    public void generateSymmetricKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        this.secretKey = keyGen.generateKey();
    }

    public void generateAsymmetricKeys() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        this.keyPair = keyPairGen.generateKeyPair();
    }

    public String getEncodedSymmetricKey() {
        if(secretKey != null) {
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        }
        return null;
    }

    public String getEncodedPublicKey() {
        if(keyPair != null) {
            return Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
        }
        return null;
    }

    public String getEncodedPrivateKey() {
        if(keyPair != null) {
            return Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            Task134 keyManager = new Task134();
            
            // Test Case 1: Generate and retrieve symmetric key
            keyManager.generateSymmetricKey();
            System.out.println("Test 1 - Symmetric Key: " + keyManager.getEncodedSymmetricKey());

            // Test Case 2: Generate and retrieve asymmetric keys
            keyManager.generateAsymmetricKeys();
            System.out.println("Test 2 - Public Key: " + keyManager.getEncodedPublicKey());
            
            // Test Case 3: Retrieve private key
            System.out.println("Test 3 - Private Key: " + keyManager.getEncodedPrivateKey());
            
            // Test Case 4: Generate new symmetric key
            keyManager.generateSymmetricKey();
            System.out.println("Test 4 - New Symmetric Key: " + keyManager.getEncodedSymmetricKey());
            
            // Test Case 5: Generate new asymmetric keys
            keyManager.generateAsymmetricKeys();
            System.out.println("Test 5 - New Public Key: " + keyManager.getEncodedPublicKey());
            
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Cryptographic algorithm not available: " + e.getMessage());
        }
    }
}
