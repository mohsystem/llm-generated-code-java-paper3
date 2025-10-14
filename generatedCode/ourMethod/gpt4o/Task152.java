package ourMethod.openai;
import java.util.LinkedList;

public class Task152 {
    static class HashNode {
        String key;
        int value;

        HashNode(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class HashTable {
        private LinkedList<HashNode>[] table;
        private int size;

        public HashTable(int size) {
            this.size = size;
            table = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                table[i] = new LinkedList<>();
            }
        }

        private int getHash(String key) {
            return Math.abs(key.hashCode() % size);
        }

        public void insert(String key, int value) {
            int hash = getHash(key);
            LinkedList<HashNode> chain = table[hash];
            for (HashNode node : chain) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
            }
            chain.add(new HashNode(key, value));
        }

        public boolean delete(String key) {
            int hash = getHash(key);
            LinkedList<HashNode> chain = table[hash];
            for (HashNode node : chain) {
                if (node.key.equals(key)) {
                    chain.remove(node);
                    return true;
                }
            }
            return false;
        }

        public Integer search(String key) {
            int hash = getHash(key);
            LinkedList<HashNode> chain = table[hash];
            for (HashNode node : chain) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.insert("apple", 1);
        hashTable.insert("banana", 2);
        hashTable.insert("cherry", 3);
        hashTable.insert("date", 4);
        hashTable.insert("elderberry", 5);

        System.out.println("Search 'apple': " + hashTable.search("apple")); // 1
        System.out.println("Search 'banana': " + hashTable.search("banana")); // 2

        System.out.println("Delete 'banana': " + hashTable.delete("banana")); // true
        System.out.println("Search 'banana': " + hashTable.search("banana")); // null

        System.out.println("Delete 'banana' again: " + hashTable.delete("banana")); // false
    }
}