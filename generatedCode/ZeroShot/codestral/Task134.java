package ZeroShot.codestral;
import java.util.HashMap;
import java.util.Map;
import java.security.SecureRandom;
import java.util.Base64;

public class Task134 {
    private Map<String, String> keys = new HashMap<>();

    public String generateKey() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public void saveKey(String id, String key) {
        keys.put(id, key);
    }

    public String getKey(String id) {
        return keys.get(id);
    }

    public static void main(String[] args) {
        Task134 manager = new Task134();
        String key1 = manager.generateKey();
        manager.saveKey("key1", key1);
        System.out.println(manager.getKey("key1"));
    }
}