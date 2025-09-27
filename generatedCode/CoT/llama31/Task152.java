package CoT.llama31;
import java.util.ArrayList;
import java.util.List;

public class Task152 {
    static class HashTable {
        int bucket;
        List<Integer>[] table;

        public HashTable(int bucket) {
            this.bucket = bucket;
            table = new List[bucket];
            for (int i = 0; i < bucket; i++) {
                table[i] = new ArrayList<>();
            }
        }

        int hashFunction(int key) {
            return key % bucket;
        }

        public void insertItem(int key) {
            int index = hashFunction(key);
            table[index].add(key);
        }

        public void deleteItem(int key) {
            int index = hashFunction(key);
            if (!table[index].contains(key)) {
                return;
            }
            table[index].remove(Integer.valueOf(key));
        }

        public boolean searchItem(int key) {
            int index = hashFunction(key);
            return table[index].contains(key);
        }

        public void displayHash() {
            for (int i = 0; i < bucket; i++) {
                System.out.print("Index " + i + ": ");
                for (int x : table[i]) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        int[] keys = {15, 11, 27, 8, 12};
        for (int key : keys) {
            hashTable.insertItem(key);
        }
        hashTable.displayHash();
        System.out.println("Searching for 11: " + hashTable.searchItem(11));
        System.out.println("Searching for 27: " + hashTable.searchItem(27));
        hashTable.deleteItem(11);
        hashTable.displayHash();
        System.out.println("Searching for 11 after deletion: " + hashTable.searchItem(11));
    }
}