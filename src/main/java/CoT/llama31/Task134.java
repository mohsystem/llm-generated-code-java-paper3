package CoT.llama31;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class Task134 {
    private Map<String, KeyPair> keyStore = new HashMap<>();

    public void generateKey(String keyId) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        keyStore.put(keyId, kp);
    }

    public KeyPair getKey(String keyId) {
        return keyStore.get(keyId);
    }

    public static void main(String[] args) throws Exception {
        Task134 km = new Task134();
        km.generateKey("key1");
        km.generateKey("key2");

        KeyPair kp1 = km.getKey("key1");
        if (kp1 != null) {
            System.out.println("Public Key: " + kp1.getPublic());
            System.out.println("Private Key: " + kp1.getPrivate());
        }

        KeyPair kp2 = km.getKey("key2");
        if (kp2 != null) {
            System.out.println("Public Key: " + kp2.getPublic());
            System.out.println("Private Key: " + kp2.getPrivate());
        }
    }
}