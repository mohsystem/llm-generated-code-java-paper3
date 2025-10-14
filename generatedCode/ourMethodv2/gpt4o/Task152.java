package ourMethodv2.gpt4o;
import java.util.ArrayList;
import java.util.LinkedList;

public class Task152 {
    static class HashTable {
        private final int SIZE = 10;
        private ArrayList<LinkedList<KeyValue>> table;

        static class KeyValue {
            String key;
            String value;

            KeyValue(String key, String value) {
                this.key = key;
                this.value = value;
            }
        }

        public HashTable() {
            table = new ArrayList<>();
            for (int i = 0; i < SIZE; i++) {
                table.add(new LinkedList<>());
            }
        }

        private int hash(String key) {
            return Math.abs(key.hashCode() % SIZE);
        }

        public void insert(String key, String value) {
            int hash = hash(key);
            LinkedList<KeyValue> bucket = table.get(hash);

            for (KeyValue kv : bucket) {
                if (kv.key.equals(key)) {
                    kv.value = value; // Update value if key already exists
                    return;
                }
            }
            bucket.add(new KeyValue(key, value));
        }

        public boolean delete(String key) {
            int hash = hash(key);
            LinkedList<KeyValue> bucket = table.get(hash);

            for (KeyValue kv : bucket) {
                if (kv.key.equals(key)) {
                    bucket.remove(kv);
                    return true;
                }
            }
            return false;
        }

        public String search(String key) {
            int hash = hash(key);
            LinkedList<KeyValue> bucket = table.get(hash);

            for (KeyValue kv : bucket) {
                if (kv.key.equals(key)) {
                    return kv.value;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.insert("key1", "value1");
        ht.insert("key2", "value2");
        ht.insert("key3", "value3");
        ht.insert("key4", "value4");
        ht.insert("key5", "value5");

        System.out.println(ht.search("key1")); // Outputs: value1
        System.out.println(ht.search("key3")); // Outputs: value3
        System.out.println(ht.delete("key2")); // Outputs: true
        System.out.println(ht.search("key2")); // Outputs: null
        System.out.println(ht.delete("key6")); // Outputs: false
    }
}