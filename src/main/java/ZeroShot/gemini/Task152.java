package ZeroShot.gemini;
import java.util.LinkedList;

class Task152 {

    private static class HashTable {
        private final int capacity;
        private final LinkedList<Entry>[] table;

        private static class Entry {
            String key;
            String value;

            Entry(String key, String value) {
                this.key = key;
                this.value = value;
            }
        }

        public HashTable(int capacity) {
            this.capacity = capacity;
            this.table = new LinkedList[capacity];
        }

        private int hash(String key) {
            return Math.abs(key.hashCode()) % capacity;
        }

        public void insert(String key, String value) {
            int index = hash(key);
            if (table[index] == null) {
                table[index] = new LinkedList<>();
            }
            for (Entry entry : table[index]) {
                if (entry.key.equals(key)) {
                    entry.value = value; // Update if key exists
                    return;
                }
            }
            table[index].add(new Entry(key, value));
        }

        public String search(String key) {
            int index = hash(key);
            if (table[index] != null) {
                for (Entry entry : table[index]) {
                    if (entry.key.equals(key)) {
                        return entry.value;
                    }
                }
            }
            return null;
        }

        public void delete(String key) {
            int index = hash(key);
            if (table[index] != null) {
                for (Entry entry : table[index]) {
                    if(entry.key.equals(key)) {
                       table[index].remove(entry);
                       return;
                    }
                }
            }
        }


        public static void main(String[] args) {
            HashTable hashTable = new HashTable(10);
            hashTable.insert("apple", "red");
            hashTable.insert("banana", "yellow");
            hashTable.insert("grape", "purple");
            System.out.println(hashTable.search("banana")); // Output: yellow
            hashTable.delete("banana");
            System.out.println(hashTable.search("banana")); // Output: null
            hashTable.insert("apple", "green"); // Update apple value
            System.out.println(hashTable.search("apple")); // Output: green


            HashTable ht = new HashTable(7);
            ht.insert("one", "1");
            ht.insert("two", "2");
            ht.insert("three", "3");
            ht.insert("four", "4");
            ht.insert("five", "5");


            System.out.println(ht.search("two"));
            ht.delete("two");
            System.out.println(ht.search("two"));


        }
    }
}