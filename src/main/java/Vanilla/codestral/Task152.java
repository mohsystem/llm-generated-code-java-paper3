package Vanilla.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task152 {
    private Map<String, Integer> hashTable = new HashMap<>();

    public void insert(String key, Integer value) {
        hashTable.put(key, value);
    }

    public void delete(String key) {
        hashTable.remove(key);
    }

    public Integer search(String key) {
        return hashTable.get(key);
    }

    public static void main(String[] args) {
        Task152 hashTable = new Task152();
        hashTable.insert("one", 1);
        hashTable.insert("two", 2);
        hashTable.insert("three", 3);

        System.out.println(hashTable.search("two")); // 2

        hashTable.delete("two");

        System.out.println(hashTable.search("two")); // null
    }
}