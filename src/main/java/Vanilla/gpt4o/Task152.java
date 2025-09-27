package Vanilla.gpt4o;
import java.util.LinkedList;

class Task152 {
    private LinkedList<Entry>[] table;
    private int capacity = 10;

    static class Entry {
        String key;
        String value;
        
        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

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
        LinkedList<Entry> entries = table[index];

        for (Entry entry : entries) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        entries.add(new Entry(key, value));
    }

    public String search(String key) {
        int index = hash(key);
        LinkedList<Entry> entries = table[index];

        for (Entry entry : entries) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void delete(String key) {
        int index = hash(key);
        LinkedList<Entry> entries = table[index];

        for (Entry entry : entries) {
            if (entry.key.equals(key)) {
                entries.remove(entry);
                return;
            }
        }
    }

    public static void main(String[] args) {
        Task152 hashTable = new Task152();
        
        hashTable.insert("key1", "value1");
        hashTable.insert("key2", "value2");
        hashTable.insert("key3", "value3");
        hashTable.insert("key4", "value4");
        hashTable.insert("key5", "value5");

        System.out.println("Search key1: " + hashTable.search("key1")); // value1
        System.out.println("Search key3: " + hashTable.search("key3")); // value3

        hashTable.delete("key2");
        System.out.println("Search key2: " + hashTable.search("key2")); // null
    }
}