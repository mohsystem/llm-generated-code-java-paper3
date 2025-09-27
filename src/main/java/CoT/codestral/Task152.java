package CoT.codestral;
import java.util.ArrayList;
import java.util.List;

class HashTable {
    private static final int SIZE = 10;
    private List<List<Integer>> table = new ArrayList<>();

    public HashTable() {
        for (int i = 0; i < SIZE; i++)
            table.add(new ArrayList<>());
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void insert(int key) {
        int hash = hash(key);
        table.get(hash).add(key);
    }

    public void delete(int key) {
        int hash = hash(key);
        table.get(hash).remove((Integer) key);
    }

    public boolean search(int key) {
        int hash = hash(key);
        return table.get(hash).contains(key);
    }
}

public class Task152 {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.insert(10);
        hashTable.insert(20);
        hashTable.insert(30);
        System.out.println(hashTable.search(20));
        hashTable.delete(20);
        System.out.println(hashTable.search(20));
    }
}