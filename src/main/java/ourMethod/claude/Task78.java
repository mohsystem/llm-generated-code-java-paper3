package ourMethod.claude;

import java.security.*;
import java.security.spec.*;
import java.util.Base64;
import java.nio.file.*;
import javax.crypto.Cipher;

public class Task78 {
    private static final int KEY_SIZE = 2048;
    
    public static String generateOpenSSHPrivateKey() throws Exception {
        // Generate RSA key pair with secure parameters
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(KEY_SIZE, SecureRandom.getInstanceStrong());
        KeyPair keyPair = keyGen.generateKeyPair();
        
        // Get private key
        PrivateKey privateKey = keyPair.getPrivate();
        
        // Encode in OpenSSH format
        byte[] encodedPrivateKey = privateKey.getEncoded();
        String opensshKey = "-----BEGIN OPENSSH PRIVATE KEY-----\\n";
        opensshKey += Base64.getEncoder().encodeToString(encodedPrivateKey);
        opensshKey += "\\n-----END OPENSSH PRIVATE KEY-----";
        
        return opensshKey;
    }
    
    public static void main(String[] args) {
        try {
            // Test cases
            for(int i = 0; i < 5; i++) {
                String key = generateOpenSSHPrivateKey();
                System.out.println("Generated Key " + (i+1) + ":");
                System.out.println(key);
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println("Error generating key: " + e.getMessage());
        }
    }
}
