package ZeroShot.gpt4o;
import java.util.LinkedList;

public class Task152 {
    private class Entry {
        String key;
        String value;

        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] table;
    private int capacity = 10;

    @SuppressWarnings("unchecked")
    public Task152() {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void insert(String key, String value) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry(key, value));
    }

    public String search(String key) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean delete(String key) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                table[index].remove(entry);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Task152 hashTable = new Task152();
        hashTable.insert("key1", "value1");
        hashTable.insert("key2", "value2");
        hashTable.insert("key3", "value3");
        hashTable.insert("key4", "value4");
        hashTable.insert("key5", "value5");

        System.out.println(hashTable.search("key1")); // value1
        System.out.println(hashTable.search("key6")); // null

        hashTable.delete("key3");
        System.out.println(hashTable.search("key3")); // null
    }
}