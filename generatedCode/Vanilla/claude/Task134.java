package Vanilla.claude;

import java.security.*;
import java.util.Base64;

public class Task134 {
    private static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        return keyGen.generateKeyPair();
    }
    
    private static String encodeKey(Key key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
    
    private static boolean verifyKeyPair(KeyPair keyPair) {
        try {
            String testMessage = "Test Message";
            Signature signature = Signature.getInstance("SHA256withRSA");
            
            // Sign with private key
            signature.initSign(keyPair.getPrivate());
            signature.update(testMessage.getBytes());
            byte[] signedData = signature.sign();
            
            // Verify with public key
            signature.initVerify(keyPair.getPublic());
            signature.update(testMessage.getBytes());
            return signature.verify(signedData);
            
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            // Test Case 1: Generate and verify key pair
            KeyPair keyPair1 = generateKeyPair();
            System.out.println("Test 1 - Key pair generated and verified: " + verifyKeyPair(keyPair1));
            
            // Test Case 2: Encode public key
            String encodedPublic = encodeKey(keyPair1.getPublic());
            System.out.println("Test 2 - Encoded public key length: " + encodedPublic.length());
            
            // Test Case 3: Encode private key
            String encodedPrivate = encodeKey(keyPair1.getPrivate());
            System.out.println("Test 3 - Encoded private key length: " + encodedPrivate.length());
            
            // Test Case 4: Generate different key pairs
            KeyPair keyPair2 = generateKeyPair();
            System.out.println("Test 4 - Different key pairs are unique: " + 
                             !encodedPublic.equals(encodeKey(keyPair2.getPublic())));
            
            // Test Case 5: Verify another key pair
            System.out.println("Test 5 - Second key pair verified: " + verifyKeyPair(keyPair2));
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
