package ZeroShot.claude;

import java.security.*;
import java.util.Base64;
import java.security.interfaces.RSAPrivateKey;

public class Task78 {
    public static String generateOpenSSHPrivateKey(int keySize) {
        try {
            // Generate key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(keySize, new SecureRandom());
            KeyPair keyPair = keyGen.generateKeyPair();
            
            // Get private key
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            
            // Encode key in Base64
            byte[] encodedPrivateKey = privateKey.getEncoded();
            String base64PrivateKey = Base64.getEncoder().encodeToString(encodedPrivateKey);
            
            // Format as OpenSSH
            return "-----BEGIN RSA PRIVATE KEY-----\\n" +
                   base64PrivateKey + "\\n" +
                   "-----END RSA PRIVATE KEY-----";
        } catch (Exception e) {
            return "Error generating key: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases with different key sizes
        int[] keySizes = {1024, 2048, 3072, 4096, 2048};
        
        for (int i = 0; i < keySizes.length; i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Key Size: " + keySizes[i] + " bits");
            String key = generateOpenSSHPrivateKey(keySizes[i]);
            System.out.println(key);
            System.out.println();
        }
    }
}
