package ZeroShot.llama31;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class Task134 {
    public static void main(String[] args) throws Exception {
        // Test cases
        String[] keyNames = {"key1", "key2", "key3", "key4", "key5"};
        KeyManager keyManager = new KeyManager();

        for (String keyName : keyNames) {
            KeyPair keyPair = keyManager.generateKeyPair();
            keyManager.storeKeyPair(keyName, keyPair);
            KeyPair retrievedKeyPair = keyManager.retrieveKeyPair(keyName);
            System.out.println("Key Name: " + keyName);
            System.out.println("Public Key: " + retrievedKeyPair.getPublic());
            System.out.println("Private Key: " + retrievedKeyPair.getPrivate());
            System.out.println();
        }
    }
}

class KeyManager {
    private Map<String, KeyPair> keyStore = new HashMap<>();

    public KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        return kpg.generateKeyPair();
    }

    public void storeKeyPair(String keyName, KeyPair keyPair) {
        keyStore.put(keyName, keyPair);
    }

    public KeyPair retrieveKeyPair(String keyName) {
        return keyStore.get(keyName);
    }
}