package ourMethod.gemini;
import java.util.LinkedList;

class Task152 {

    private static final int TABLE_SIZE = 10;

    private LinkedList<Entry>[] table;

    public Task152() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % TABLE_SIZE;
    }

    public void insert(int key, int value) {
        int index = hash(key);
        table[index].add(new Entry(key, value));
    }

    public Integer search(int key) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return null;
    }

    public void delete(int key) {
        int index = hash(key);
        table[index].removeIf(entry -> entry.key == key);
    }

    private static class Entry {
        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Task152 ht = new Task152();

        // Test cases
        ht.insert(1, 10);
        ht.insert(2, 20);
        ht.insert(11, 110); // Collision with 1
        ht.insert(22, 220);

        System.out.println("Search 2: " + ht.search(2)); // Output: 20
        System.out.println("Search 11: " + ht.search(11)); // Output: 110
        System.out.println("Search 3: " + ht.search(3)); // Output: null

        ht.delete(11);
        System.out.println("Search 11 after deletion: " + ht.search(11)); // Output: null
        System.out.println("Search 1: " + ht.search(1)); // Output: 10
       
        ht.insert(5, 50);
        ht.insert(15, 150);
        System.out.println("Search 15: " + ht.search(15)); // Output: 150
        System.out.println("Search 5: " + ht.search(5)); // Output: 50

    }
}