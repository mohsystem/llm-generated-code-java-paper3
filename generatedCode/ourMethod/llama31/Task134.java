package ourMethod.llama31;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class Task134 {
    private static Map<String, KeyPair> keyPairs = new HashMap<>();

    public static void main(String[] args) throws Exception {
        // Generate a key pair
        KeyPair keyPair = generateKeyPair();
        String keyId = "myKey";
        keyPairs.put(keyId, keyPair);

        // Use the key pair
        PublicKey publicKey = keyPairs.get(keyId).getPublic();
        PrivateKey privateKey = keyPairs.get(keyId).getPrivate();

        // Delete the key pair
        deleteKeyPair(keyId);
    }

    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        return kpg.generateKeyPair();
    }

    public static void deleteKeyPair(String keyId) {
        keyPairs.remove(keyId);
    }
}