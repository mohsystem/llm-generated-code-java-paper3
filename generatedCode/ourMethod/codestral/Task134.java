package ourMethod.codestral;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class CryptographicKeyManager {
    private Map<String, KeyPair> keys;

    public CryptographicKeyManager() {
        keys = new HashMap<>();
    }

    public void generateKey(String id) throws NoSuchAlgorithmException {
        if (keys.containsKey(id)) {
            throw new IllegalArgumentException("Key with ID " + id + " already exists.");
        }
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        keys.put(id, keyGen.generateKeyPair());
    }

    public KeyPair getKey(String id) {
        if (!keys.containsKey(id)) {
            throw new IllegalArgumentException("Key with ID " + id + " does not exist.");
        }
        return keys.get(id);
    }

    public void deleteKey(String id) {
        if (!keys.containsKey(id)) {
            throw new IllegalArgumentException("Key with ID " + id + " does not exist.");
        }
        keys.remove(id);
    }
}