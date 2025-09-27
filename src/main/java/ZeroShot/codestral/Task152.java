package ZeroShot.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task152 {
    private Map<Integer, String> hashTable = new HashMap<>();

    public void insert(Integer key, String value) {
        hashTable.put(key, value);
    }

    public void delete(Integer key) {
        hashTable.remove(key);
    }

    public String search(Integer key) {
        return hashTable.get(key);
    }

    public static void main(String[] args) {
        Task152 hashTable = new Task152();
        hashTable.insert(1, "One");
        hashTable.insert(2, "Two");
        hashTable.insert(3, "Three");
        System.out.println(hashTable.search(2)); // Two
        hashTable.delete(2);
        System.out.println(hashTable.search(2)); // null
    }
}