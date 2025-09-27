package CoT.claude;

// Java implementation requires external libraries (Bouncy Castle) for RSA key generation and OpenSSH format
import java.security.*;
import java.util.Base64;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class Task78 {
    public static String generateOpenSSHPrivateKey() {
        try {
            // Generate key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048, new SecureRandom()); 
            KeyPair keyPair = keyGen.generateKeyPair();
            
            // Get private key
            RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();
            
            // Convert to PKCS#8 format
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
            
            // Base64 encode
            String opensshKey = "-----BEGIN OPENSSH PRIVATE KEY-----\\n";
            opensshKey += Base64.getEncoder().encodeToString(pkcs8EncodedKeySpec.getEncoded());
            opensshKey += "\\n-----END OPENSSH PRIVATE KEY-----";
            
            return opensshKey;
            
        } catch (NoSuchAlgorithmException e) {
            return "Error generating key: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Test cases
        for(int i = 0; i < 5; i++) {
            System.out.println("Test case " + (i+1) + ":");
            String key = generateOpenSSHPrivateKey();
            System.out.println(key);
            System.out.println();
        }
    }
}
