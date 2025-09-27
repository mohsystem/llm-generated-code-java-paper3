package CoT.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task134 {
    private Map<String, String> keys;

    public Task134() {
        this.keys = new HashMap<>();
    }

    public void addKey(String keyName, String keyValue) {
        keys.put(keyName, keyValue);
    }

    public String getKey(String keyName) {
        return keys.get(keyName);
    }

    public void removeKey(String keyName) {
        keys.remove(keyName);
    }

    public static void main(String[] args) {
        Task134 keyManager = new Task134();
        keyManager.addKey("key1", "value1");
        keyManager.addKey("key2", "value2");
        System.out.println(keyManager.getKey("key1"));
        keyManager.removeKey("key1");
        System.out.println(keyManager.getKey("key1"));
    }
}