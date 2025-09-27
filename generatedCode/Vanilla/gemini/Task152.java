package Vanilla.gemini;
import java.util.HashMap;

public class Task152 {

    private HashMap<Integer, Integer> hashMap;

    public Task152() {
        hashMap = new HashMap<>();
    }

    public void insert(int key, int value) {
        hashMap.put(key, value);
    }

    public void delete(int key) {
        hashMap.remove(key);
    }

    public Integer search(int key) {
        return hashMap.get(key);
    }

    public static void main(String[] args) {
        Task152 hashTable = new Task152();

        // Test cases
        hashTable.insert(1, 10);
        hashTable.insert(2, 20);
        hashTable.insert(3, 30);
        hashTable.insert(4, 40);
        hashTable.insert(5, 50);


        System.out.println(hashTable.search(2)); // Output: 20
        hashTable.delete(2);
        System.out.println(hashTable.search(2)); // Output: null
        System.out.println(hashTable.search(4)); // Output: 40
        hashTable.insert(3, 35);  // Update value
        System.out.println(hashTable.search(3)); // Output: 35
        System.out.println(hashTable.search(6)); // Output: null


    }
}