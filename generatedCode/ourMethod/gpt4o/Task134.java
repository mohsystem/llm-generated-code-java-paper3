package ourMethod.openai;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Task134 {

    private Map<String, Key> keyStore = new HashMap<>();

    public KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        return keyGen.generateKeyPair();
    }

    public SecretKey generateAESKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // 256-bit AES key
        return keyGen.generateKey();
    }

    public void storeKey(String alias, Key key) {
        keyStore.put(alias, key);
    }

    public Key retrieveKey(String alias) {
        return keyStore.get(alias);
    }

    public static void main(String[] args) {
        try {
            Task134 task = new Task134();
            
            KeyPair rsaKeyPair1 = task.generateRSAKeyPair();
            task.storeKey("rsaKeyPair1Public", rsaKeyPair1.getPublic());
            task.storeKey("rsaKeyPair1Private", rsaKeyPair1.getPrivate());
            
            KeyPair rsaKeyPair2 = task.generateRSAKeyPair();
            task.storeKey("rsaKeyPair2Public", rsaKeyPair2.getPublic());
            task.storeKey("rsaKeyPair2Private", rsaKeyPair2.getPrivate());
            
            SecretKey aesKey1 = task.generateAESKey();
            task.storeKey("aesKey1", aesKey1);
            
            SecretKey aesKey2 = task.generateAESKey();
            task.storeKey("aesKey2", aesKey2);

            SecretKey aesKey3 = task.generateAESKey();
            task.storeKey("aesKey3", aesKey3);
            
            // Test retrieval of keys
            System.out.println("Retrieved RSA Public Key: " + task.retrieveKey("rsaKeyPair1Public"));
            System.out.println("Retrieved RSA Private Key: " + task.retrieveKey("rsaKeyPair1Private"));
            System.out.println("Retrieved AES Key: " + task.retrieveKey("aesKey1"));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}