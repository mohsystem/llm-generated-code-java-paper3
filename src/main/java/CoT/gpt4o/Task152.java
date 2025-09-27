package CoT.gpt4o;
import java.util.LinkedList;

public class Task152 {
    static class HashTable {
        private static final int INITIAL_SIZE = 16;
        private LinkedList<Entry>[] table;

        static class Entry {
            String key;
            String value;

            Entry(String key, String value) {
                this.key = key;
                this.value = value;
            }
        }

        public HashTable() {
            table = new LinkedList[INITIAL_SIZE];
            for (int i = 0; i < INITIAL_SIZE; i++) {
                table[i] = new LinkedList<>();
            }
        }

        private int hash(String key) {
            return Math.abs(key.hashCode()) % INITIAL_SIZE;
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

        public void delete(String key) {
            int index = hash(key);
            table[index].removeIf(entry -> entry.key.equals(key));
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.insert("key1", "value1");
        hashTable.insert("key2", "value2");
        hashTable.insert("key3", "value3");
        hashTable.delete("key2");
        System.out.println(hashTable.search("key1")); // value1
        System.out.println(hashTable.search("key2")); // null
        System.out.println(hashTable.search("key3")); // value3
        hashTable.insert("key3", "value3_updated");
        System.out.println(hashTable.search("key3")); // value3_updated
    }
}