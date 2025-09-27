package CoT.gemini;
import java.util.LinkedList;

class Task152 {

    private static final int TABLE_SIZE = 10; // Size of the hash table

    private LinkedList<Entry>[] table;

    static class Entry {
        String key;
        String value;

        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public Task152() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % TABLE_SIZE;
    }

    public void insert(String key, String value) {
        int index = hash(key);
        table[index].add(new Entry(key, value));
    }

    public void delete(String key) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                table[index].remove(entry);
                return;
            }
        }
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


    public static void main(String[] args) {
        Task152 hashTable = new Task152();

        // Test cases
        hashTable.insert("apple", "red");
        hashTable.insert("banana", "yellow");
        hashTable.insert("grape", "purple");
        hashTable.insert("orange", "orange");
        hashTable.insert("kiwi", "green");

        System.out.println("Search for apple: " + hashTable.search("apple"));
        System.out.println("Search for grape: " + hashTable.search("grape"));
        System.out.println("Search for nonexistent: " + hashTable.search("nonexistent"));


        hashTable.delete("banana");
        System.out.println("Search for banana after deletion: " + hashTable.search("banana"));

        hashTable.insert("apple", "green"); // Update value
        System.out.println("Search for apple after update: " + hashTable.search("apple"));


    }
}