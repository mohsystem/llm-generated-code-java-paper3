package CoT.openai;
import java.util.HashMap;
import java.util.Map;
import java.security.Key;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Task134 {

    private Map<String, SecretKey> keyStore;

    public Task134() {
        keyStore = new HashMap<>();
    }

    public String createKey(String algorithm) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(algorithm);
        keyGen.init(256); // Example: using 256-bit keys
        SecretKey secretKey = keyGen.generateKey();
        String keyId = "key" + keyStore.size();
        keyStore.put(keyId, secretKey);
        return keyId;
    }

    public SecretKey getKey(String keyId) {
        return keyStore.get(keyId);
    }

    public void deleteKey(String keyId) {
        keyStore.remove(keyId);
    }

    public static void main(String[] args) {
        try {
            Task134 manager = new Task134();
            String keyId1 = manager.createKey("AES");
            String keyId2 = manager.createKey("AES");
            String keyId3 = manager.createKey("AES");
            String keyId4 = manager.createKey("AES");
            String keyId5 = manager.createKey("AES");

            System.out.println("KeyId1: " + keyId1 + " Key: " + manager.getKey(keyId1));
            System.out.println("KeyId2: " + keyId2 + " Key: " + manager.getKey(keyId2));
            System.out.println("KeyId3: " + keyId3 + " Key: " + manager.getKey(keyId3));
            System.out.println("KeyId4: " + keyId4 + " Key: " + manager.getKey(keyId4));
            System.out.println("KeyId5: " + keyId5 + " Key: " + manager.getKey(keyId5));
            
            manager.deleteKey(keyId3);
            System.out.println("After deletion, KeyId3: " + manager.getKey(keyId3));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}