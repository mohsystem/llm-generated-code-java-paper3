package Vanilla.llama31;
public class Task152 {
    static class HashTable {
        int[] table;
        int size;

        public HashTable(int size) {
            this.size = size;
            this.table = new int[size];
            for (int i = 0; i < size; i++) {
                table[i] = -1;
            }
        }

        int hashFunction(int key) {
            return key % size;
        }

        public void insertItem(int key) {
            int index = hashFunction(key);
            if (table[index] == -1) {
                table[index] = key;
            } else {
                System.out.println("Collision: Unable to insert " + key);
            }
        }

        public void deleteItem(int key) {
            int index = hashFunction(key);
            if (table[index] == key) {
                table[index] = -1;
            } else {
                System.out.println(key + " not present in the hash table");
            }
        }

        public void searchItem(int key) {
            int index = hashFunction(key);
            if (table[index] == key) {
                System.out.println("Search Found");
            } else {
                System.out.println("Search Not Found");
            }
        }

        public void displayHash() {
            for (int i = 0; i < size; i++) {
                System.out.print("table[" + i + "] = " + table[i] + "\n");
            }
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        hashTable.insertItem(10);
        hashTable.insertItem(4);
        hashTable.insertItem(2);
        hashTable.insertItem(3);
        hashTable.displayHash();
        System.out.println("Deleting value 10..");
        hashTable.deleteItem(10);
        hashTable.displayHash();
        System.out.println("Deleting value 5..");
        hashTable.deleteItem(5);
        hashTable.displayHash();
        System.out.println("Searching value 4..");
        hashTable.searchItem(4);
        System.out.println("Searching value 10..");
        hashTable.searchItem(10);
    }
}