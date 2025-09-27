package ZeroShot.llama31;
import java.util.ArrayList;
import java.util.List;

class HashNode {
    int key;
    int value;
    HashNode next;

    public HashNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class Task152 {
    private static final int INITIAL_CAPACITY = 10;
    private static final float LOAD_FACTOR = 0.7f;
    private List<HashNode>[] buckets;
    private int size;
    private int numBuckets;

    public Task152() {
        buckets = new List[INITIAL_CAPACITY];
        numBuckets = INITIAL_CAPACITY;
        size = 0;
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    private int hash(int key) {
        return key % numBuckets;
    }

    public void insert(int key, int value) {
        int index = hash(key);
        for (HashNode node : buckets[index]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        buckets[index].add(new HashNode(key, value));
        size++;
        if ((float) size / numBuckets > LOAD_FACTOR) {
            resize();
        }
    }

    public int search(int key) {
        int index = hash(key);
        for (HashNode node : buckets[index]) {
            if (node.key == key) {
                return node.value;
            }
        }
        return -1; // Key not found
    }

    public void delete(int key) {
        int index = hash(key);
        for (int i = 0; i < buckets[index].size(); i++) {
            if (buckets[index].get(i).key == key) {
                buckets[index].remove(i);
                size--;
                return;
            }
        }
    }

    private void resize() {
        numBuckets *= 2;
        List<HashNode>[] newBuckets = new List[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            newBuckets[i] = new ArrayList<>();
        }
        for (List<HashNode> bucket : buckets) {
            for (HashNode node : bucket) {
                int newIndex = node.key % numBuckets;
                newBuckets[newIndex].add(node);
            }
        }
        buckets = newBuckets;
    }

    public static void main(String[] args) {
        Task152 hashTable = new Task152();
        hashTable.insert(1, 10);
        hashTable.insert(2, 20);
        hashTable.insert(3, 30);
        System.out.println("Search 1: " + hashTable.search(1)); // Output: 10
        System.out.println("Search 2: " + hashTable.search(2)); // Output: 20
        hashTable.delete(2);
        System.out.println("Search 2 after delete: " + hashTable.search(2)); // Output: -1
    }
}